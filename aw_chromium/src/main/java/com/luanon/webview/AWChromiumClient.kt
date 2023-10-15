package com.luanon.webview

import android.graphics.Bitmap
import android.graphics.Picture
import android.net.http.SslError
import android.os.Looper
import android.os.Message
import android.view.KeyEvent
import android.view.View
import org.chromium.android_webview.AwConsoleMessage
import org.chromium.android_webview.AwContentsClient
import org.chromium.android_webview.AwContentsClientBridge.ClientCertificateRequestCallback
import org.chromium.android_webview.AwGeolocationPermissions
import org.chromium.android_webview.AwHttpAuthHandler
import org.chromium.android_webview.AwRenderProcess
import org.chromium.android_webview.AwRenderProcessGoneDetail
import org.chromium.android_webview.JsPromptResultReceiver
import org.chromium.android_webview.JsResultReceiver
import org.chromium.android_webview.SafeBrowsingAction
import org.chromium.android_webview.permission.AwPermissionRequest
import org.chromium.android_webview.safe_browsing.AwSafeBrowsingResponse
import org.chromium.base.Callback
import org.chromium.base.ThreadUtils
import org.chromium.components.embedder_support.util.WebResourceResponseInfo
import java.security.Principal

open class AwChromiumClient @JvmOverloads constructor(looper: Looper? = ThreadUtils.getUiThreadLooper()) :
    AwContentsClient(looper) {

    override fun hasWebViewClient(): Boolean = true

    override fun shouldOverrideUrlLoading(request: AwWebResourceRequest): Boolean = false

    override fun onUnhandledKeyEvent(event: KeyEvent) {}

    override fun getVisitedHistory(callback: Callback<Array<String>>) {}

    override fun doUpdateVisitedHistory(url: String, isReload: Boolean) {}

    override fun onProgressChanged(progress: Int) {}

    override fun shouldInterceptRequest(request: AwWebResourceRequest): WebResourceResponseInfo? =
        null

    override fun shouldOverrideKeyEvent(event: KeyEvent): Boolean = false

    override fun onLoadResource(url: String) {}

    override fun onConsoleMessage(consoleMessage: AwConsoleMessage): Boolean = false

    override fun onReceivedHttpAuthRequest(
        handler: AwHttpAuthHandler, host: String, realm: String
    ) {
        handler.cancel()
    }

    override fun onReceivedSslError(callback: Callback<Boolean>, error: SslError) {
        callback.onResult(false)
    }

    override fun onReceivedClientCertRequest(
        callback: ClientCertificateRequestCallback,
        keyTypes: Array<String>,
        principals: Array<Principal>,
        host: String,
        port: Int
    ) {
        callback.proceed(null, null)
    }

    override fun onReceivedLoginRequest(realm: String, account: String, args: String) {}

    override fun showFileChooser(
        uploadFilePathsCallback: Callback<Array<String>>, fileChooserParams: FileChooserParamsImpl
    ) {
    }

    override fun onGeolocationPermissionsShowPrompt(
        origin: String, callback: AwGeolocationPermissions.Callback
    ) {
    }

    override fun onGeolocationPermissionsHidePrompt() {}

    public override fun handleJsAlert(url: String, message: String, receiver: JsResultReceiver) {
        receiver.cancel()
    }

    public override fun handleJsBeforeUnload(
        url: String, message: String, receiver: JsResultReceiver
    ) {
        receiver.confirm()
    }

    public override fun handleJsConfirm(url: String, message: String, receiver: JsResultReceiver) {
        receiver.cancel()
    }

    public override fun handleJsPrompt(
        url: String, message: String, defaultValue: String, receiver: JsPromptResultReceiver
    ) {
        receiver.cancel()
    }

    override fun onFindResultReceived(
        activeMatchOrdinal: Int, numberOfMatches: Int, isDoneCounting: Boolean
    ) {
    }

    override fun onNewPicture(picture: Picture) {}

    override fun onPageStarted(url: String) {}

    override fun onPageFinished(url: String) {}

    override fun onPageCommitVisible(url: String) {}

    public override fun onReceivedError(errorCode: Int, description: String, failingUrl: String) {}

    public override fun onReceivedError2(
        request: AwWebResourceRequest, error: AwWebResourceError
    ) {
    }

    public override fun onSafeBrowsingHit(
        request: AwWebResourceRequest, threatType: Int, callback: Callback<AwSafeBrowsingResponse>
    ) {
        callback.onResult(
            AwSafeBrowsingResponse(
                SafeBrowsingAction.SHOW_INTERSTITIAL, true
            )
        )
    }

    override fun onReceivedHttpError(
        request: AwWebResourceRequest, response: WebResourceResponseInfo
    ) {
    }

    override fun onFormResubmission(dontResend: Message, resend: Message) {
        dontResend.sendToTarget()
    }

    override fun onDownloadStart(
        url: String,
        userAgent: String,
        contentDisposition: String,
        mimeType: String,
        contentLength: Long
    ) {
    }

    public override fun onCreateWindow(isDialog: Boolean, isUserGesture: Boolean): Boolean = false

    public override fun onCloseWindow() {}

    public override fun onRequestFocus() {}

    override fun onReceivedTouchIconUrl(url: String, precomposed: Boolean) {}

    override fun onReceivedIcon(bitmap: Bitmap) {}

    override fun onReceivedTitle(title: String) {}

    override fun onShowCustomView(view: View, callback: CustomViewCallback) {}

    override fun onHideCustomView() {}

    override fun onScaleChangedScaled(oldScale: Float, newScale: Float) {}

    override fun getVideoLoadingProgressView(): View? = null

    override fun getDefaultVideoPoster(): Bitmap? = null

    override fun onPermissionRequest(awPermissionRequest: AwPermissionRequest) {
        awPermissionRequest.deny()
    }

    override fun onPermissionRequestCanceled(awPermissionRequest: AwPermissionRequest) {}

    override fun onRendererUnresponsive(process: AwRenderProcess) {}

    override fun onRendererResponsive(process: AwRenderProcess) {}

    override fun onRenderProcessGone(detail: AwRenderProcessGoneDetail): Boolean = false
}
