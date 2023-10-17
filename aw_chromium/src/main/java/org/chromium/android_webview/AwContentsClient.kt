// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Picture
import android.net.Uri
import android.net.http.SslError
import android.os.Build
import android.os.Looper
import android.os.Message
import android.provider.Browser
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import androidx.annotation.RequiresApi
import org.chromium.android_webview.AwContentsClientBridge.ClientCertificateRequestCallback
import org.chromium.android_webview.permission.AwPermissionRequest
import org.chromium.android_webview.safe_browsing.AwSafeBrowsingResponse
import org.chromium.base.Callback
import org.chromium.base.ContextUtils
import org.chromium.base.Log
import org.chromium.base.metrics.RecordHistogram
import org.chromium.base.metrics.ScopedSysTraceEvent
import org.chromium.components.embedder_support.util.UrlConstants
import org.chromium.components.embedder_support.util.WebResourceResponseInfo
import org.chromium.content_public.common.ContentUrlConstants
import java.security.Principal
import java.util.regex.Pattern

/**
 * Base-class that an AwContents embedder derives from to receive callbacks.
 * For any other callbacks we need to make transformations of (e.g. adapt parameters
 * or perform filtering) we can provide final overrides for methods here, and then introduce
 * new abstract methods that the our own client must implement.
 * i.e.: all methods in this class should either be final, or abstract.
 */
abstract class AwContentsClient @JvmOverloads constructor(looper: Looper? = Looper.myLooper()) {
    var callbackHelper: AwContentsClientCallbackHelper? = null

    // Last background color reported from the renderer. Holds the sentinal value INVALID_COLOR
    // if not valid.
    private var mCachedRendererBackgroundColor = INVALID_COLOR

    // Holds the last known page title. {@link ContentViewClient#onUpdateTitle} is unreliable,
    // particularly for navigating backwards and forwards in the history stack. Instead, the last
    // known document title is kept here, and the clients gets updated whenever the value has
    // actually changed. Blink also only sends updates when the document title have changed,
    // so behaviours are consistent.
    private var mTitle = ""

    /**
     *
     * See [android.webkit.WebChromeClient].  */
    interface CustomViewCallback {
        /* See {@link android.webkit.WebChromeClient}. */
        fun onCustomViewHidden()
    }

    // Alllow injection of the callback thread, for testing.
    init {
        ScopedSysTraceEvent.scoped("AwContentsClient.constructorOneArg").use {
            callbackHelper = AwContentsClientCallbackHelper(
                looper!!, this
            )
        }
    }

    val cachedRendererBackgroundColor: Int
        get() {
            assert(isCachedRendererBackgroundColorValid)
            return mCachedRendererBackgroundColor
        }
    val isCachedRendererBackgroundColorValid: Boolean
        get() = mCachedRendererBackgroundColor != INVALID_COLOR

    fun onBackgroundColorChanged(color: Int) {
        // Avoid storing the sentinal INVALID_COLOR (note that both 0 and 1 are both
        // fully transparent so this transpose makes no visible difference).
        mCachedRendererBackgroundColor = if (color == INVALID_COLOR) 1 else color
    }
    //--------------------------------------------------------------------------------------------
    //             WebView specific methods that map directly to WebViewClient / WebChromeClient
    //--------------------------------------------------------------------------------------------
    /**
     * Parameters for the [AwContentsClient.shouldInterceptRequest] method.
     */
    class AwWebResourceRequest {
        constructor(
            url: String?, isMainFrame: Boolean, hasUserGesture: Boolean,
            method: String?, requestHeaders: HashMap<String, String>?
        ) {
            this.url = url
            this.isMainFrame = isMainFrame
            this.hasUserGesture = hasUserGesture
            // Note: we intentionally let isRedirect default initialize to false. This is because we
            // don't always know if this request is associated with a redirect or not.
            this.method = method
            this.requestHeaders = requestHeaders
        }

        constructor(
            url: String?, isMainFrame: Boolean, hasUserGesture: Boolean,
            method: String?, requestHeaderNames: Array<String>,
            requestHeaderValues: Array<String>
        ) : this(
            url, isMainFrame, hasUserGesture, method,
            HashMap<String, String>(requestHeaderValues.size)
        ) {
            for (i in requestHeaderNames.indices) {
                requestHeaders!![requestHeaderNames[i]] = requestHeaderValues[i]
            }
        }

        // Url of the request.
        @JvmField
        var url: String? = null

        // Is this for the main frame or a child iframe?
        @JvmField
        var isMainFrame = false

        // Was a gesture associated with the request? Don't trust can easily be spoofed.
        var hasUserGesture = false

        // Was it a result of a server-side redirect?
        var isRedirect = false

        // Method used (GET/POST/OPTIONS)
        var method: String? = null

        // Headers that would have been sent to server.
        private var requestHeaders: HashMap<String, String>? = null
    }

    /**
     * Parameters for [AwContentsClient.onReceivedError] method.
     */
    class AwWebResourceError {
        @RequiresApi(Build.VERSION_CODES.O)
        @JvmField
        @WebviewErrorCode
        var errorCode = WebviewErrorCode.ERROR_UNKNOWN
        @JvmField
        var description: String? = null
    }

    /**
     * Allow default implementations in chromium code.
     */
    abstract fun hasWebViewClient(): Boolean
    abstract fun getVisitedHistory(callback: Callback<Array<String?>?>?)
    abstract fun doUpdateVisitedHistory(url: String?, isReload: Boolean)
    abstract fun onProgressChanged(progress: Int)
    abstract fun shouldInterceptRequest(request: AwWebResourceRequest?): WebResourceResponseInfo?
    abstract fun shouldOverrideKeyEvent(event: KeyEvent?): Boolean
    abstract fun shouldOverrideUrlLoading(request: AwWebResourceRequest?): Boolean
    abstract fun onLoadResource(url: String?)
    abstract fun onUnhandledKeyEvent(event: KeyEvent?)
    abstract fun onConsoleMessage(consoleMessage: AwConsoleMessage?): Boolean
    abstract fun onReceivedHttpAuthRequest(
        handler: AwHttpAuthHandler?,
        host: String?, realm: String?
    )

    abstract fun onReceivedSslError(callback: Callback<Boolean?>?, error: SslError?)
    abstract fun onReceivedClientCertRequest(
        callback: ClientCertificateRequestCallback?,
        keyTypes: Array<String?>?, principals: Array<Principal?>?, host: String?,
        port: Int
    )

    abstract fun onReceivedLoginRequest(realm: String?, account: String?, args: String?)
    abstract fun onFormResubmission(dontResend: Message?, resend: Message?)
    abstract fun onDownloadStart(
        url: String?, userAgent: String?, contentDisposition: String?,
        mimeType: String?, contentLength: Long
    )

    fun shouldIgnoreNavigation(
        context: Context, url: String, isMainFrame: Boolean,
        hasUserGesture: Boolean, isRedirect: Boolean
    ): Boolean {
        val poller = callbackHelper!!.cancelCallbackPoller
        if (poller != null && poller.shouldCancelAllCallbacks()) return false
        return if (hasWebViewClient()) {
            // Note: only GET requests can be overridden, so we hardcode the method.
            val request = AwWebResourceRequest(url, isMainFrame, hasUserGesture, "GET", null)
            request.isRedirect = isRedirect
            shouldOverrideUrlLoading(request)
        } else {
            sendBrowsingIntent(context, url, hasUserGesture, isRedirect)
        }
    }

    /**
     * Type adaptation class for [android.webkit.FileChooserParams].
     */
    class FileChooserParamsImpl(
        val mode: Int, private val mTitle: String
    ) {

        val title: CharSequence
            get() = mTitle

    }

    abstract fun showFileChooser(
        uploadFilePathsCallback: Callback<Array<String?>?>?,
        fileChooserParams: FileChooserParamsImpl?
    )

    abstract fun onGeolocationPermissionsShowPrompt(
        origin: String?, callback: AwGeolocationPermissions.Callback?
    )

    abstract fun onGeolocationPermissionsHidePrompt()
    abstract fun onPermissionRequest(awPermissionRequest: AwPermissionRequest?)
    abstract fun onPermissionRequestCanceled(awPermissionRequest: AwPermissionRequest?)
    abstract fun onScaleChangedScaled(oldScale: Float, newScale: Float)
    abstract fun handleJsAlert(url: String?, message: String?, receiver: JsResultReceiver?)
    abstract fun handleJsBeforeUnload(
        url: String?, message: String?,
        receiver: JsResultReceiver?
    )

    abstract fun handleJsConfirm(url: String?, message: String?, receiver: JsResultReceiver?)
    abstract fun handleJsPrompt(
        url: String?, message: String?, defaultValue: String?,
        receiver: JsPromptResultReceiver?
    )

    abstract fun onCreateWindow(isDialog: Boolean, isUserGesture: Boolean): Boolean
    abstract fun onCloseWindow()
    abstract fun onReceivedTouchIconUrl(url: String?, precomposed: Boolean)
    abstract fun onReceivedIcon(bitmap: Bitmap?)
    abstract fun onReceivedTitle(title: String?)
    abstract fun onRequestFocus()
    protected abstract val videoLoadingProgressView: View?
    abstract fun onPageStarted(url: String?)
    abstract fun onPageFinished(url: String?)
    abstract fun onPageCommitVisible(url: String?)
    @RequiresApi(Build.VERSION_CODES.O)
    fun onReceivedError(request: AwWebResourceRequest, error: AwWebResourceError) {
        // Only one of these callbacks actually reaches out the client code. The first callback
        // is used on API versions up to and including L, the second on subsequent releases.
        // Below is the calls diagram:
        //
        //                           Old (<= L) glue              Old (<= L) android.webkit API
        //                             onReceivedError --------->   onReceivedError
        //  AwContentsClient           onReceivedError2 ->X   /
        //   abs. onReceivedError                            /
        //   abs. onReceivedError2                          /
        //                           New (M+) glue         /      New (M+) android.webkit API
        //                             onReceivedError    /     ->  onReceviedError <new>
        //   "->X" = "do nothing"        if (!<M API>) ---     /      if (isMainFrame) -\
        //                               else ->X             /       else ->X          |
        //                             onReceivedError2      /                          V
        //                               if (<M API>) -------       onReceivedError <old>
        //                               else ->X
        if (request.isMainFrame) {
            onReceivedError(error.errorCode, error.description, request.url)
        }
        onReceivedError2(request, error)

        // Record UMA on error code distribution here.
        RecordHistogram.recordSparseHistogram(
            "Android.WebView.onReceivedError.ErrorCode", error.errorCode
        )
    }

    protected abstract fun onReceivedError(
        errorCode: Int,
        description: String?,
        failingUrl: String?
    )

    protected abstract fun onReceivedError2(
        request: AwWebResourceRequest?, error: AwWebResourceError?
    )

    abstract fun onSafeBrowsingHit(
        request: AwWebResourceRequest?, threatType: Int,
        callback: Callback<AwSafeBrowsingResponse?>?
    )

    abstract fun onReceivedHttpError(
        request: AwWebResourceRequest?, response: WebResourceResponseInfo?
    )

    abstract fun onShowCustomView(view: View?, callback: CustomViewCallback?)
    abstract fun onHideCustomView()
    abstract val defaultVideoPoster: Bitmap?

    //--------------------------------------------------------------------------------------------
    //                              Other WebView-specific methods
    //--------------------------------------------------------------------------------------------
    //
    abstract fun onFindResultReceived(
        activeMatchOrdinal: Int, numberOfMatches: Int,
        isDoneCounting: Boolean
    )

    /**
     * Called whenever there is a new content picture available.
     * @param picture New picture.
     */
    abstract fun onNewPicture(picture: Picture?)
    fun updateTitle(title: String, forceNotification: Boolean) {
        if (!forceNotification && TextUtils.equals(mTitle, title)) return
        mTitle = title
        callbackHelper!!.postOnReceivedTitle(mTitle)
    }

    abstract fun onRendererUnresponsive(renderProcess: AwRenderProcess?)
    abstract fun onRendererResponsive(renderProcess: AwRenderProcess?)
    abstract fun onRenderProcessGone(detail: AwRenderProcessGoneDetail?): Boolean

    companion object {
        private const val TAG = "AwContentsClient"
        private const val INVALID_COLOR = 0
        private val FILE_ANDROID_ASSET_PATTERN = Pattern.compile("^file:///android_(asset|res)/.*")
        private fun sendBrowsingIntent(
            context: Context, url: String, hasUserGesture: Boolean,
            isRedirect: Boolean
        ): Boolean {
            if (!hasUserGesture && !isRedirect) {
                Log.w(TAG, "Denied starting an intent without a user gesture, URI %s", url)
                return true
            }

            // Treat some URLs as internal, always open them in the WebView:
            // * about: scheme URIs
            // * chrome:// scheme URIs
            // * file:///android_asset/ or file:///android_res/ URIs
            if (url.startsWith(ContentUrlConstants.ABOUT_URL_SHORT_PREFIX)
                || url.startsWith(UrlConstants.CHROME_URL_PREFIX)
                || FILE_ANDROID_ASSET_PATTERN.matcher(url).matches()
            ) {
                return false
            }
            // Perform generic parsing of the URI to turn it into an Intent.
            val intent: Intent = try {
                Intent.parseUri(url, Intent.URI_INTENT_SCHEME)
            } catch (ex: Exception) {
                Log.w(TAG, "Bad URI %s", url, ex)
                return false
            }
            // Sanitize the Intent, ensuring web pages can not bypass browser
            // security (only access to BROWSABLE activities).
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.component = null
            val selector = intent.selector
            if (selector != null) {
                selector.addCategory(Intent.CATEGORY_BROWSABLE)
                selector.component = null
            }

            // Pass the package name as application ID so that the intent from the
            // same application can be opened in the same tab.
            intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.packageName)

            // Check whether the context is activity context.
            if (ContextUtils.activityFromContext(context) == null) {
                Log.w(TAG, "Cannot call startActivity on non-activity context.")
                return false
            }
            try {
                context.startActivity(intent)
                return true
            } catch (ex: ActivityNotFoundException) {
                Log.w(TAG, "No application can handle %s", url)
            } catch (ex: SecurityException) {
                // This can happen if the Activity is exported="true", guarded by a permission, and sets
                // up an intent filter matching this intent. This is a valid configuration for an
                // Activity, so instead of crashing, we catch the exception and do nothing. See
                // https://crbug.com/808494 and https://crbug.com/889300.
                Log.w(TAG, "SecurityException when starting intent for %s", url)
            }
            return false
        }

        fun parseFileChooserResult(resultCode: Int, intent: Intent?): Array<Uri?>? {
            if (resultCode == Activity.RESULT_CANCELED) {
                return null
            }
            val result =
                if (intent == null || resultCode != Activity.RESULT_OK) null else intent.data
            var uris: Array<Uri?>? = null
            if (result != null) {
                uris = arrayOfNulls(1)
                uris[0] = result
            }
            return uris
        }
    }
}