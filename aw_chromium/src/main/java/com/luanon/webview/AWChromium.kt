package com.luanon.webview

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.annotation.Keep
import org.chromium.android_webview.AwBrowserContext
import org.chromium.android_webview.AwBrowserProcess
import org.chromium.android_webview.AwContents
import org.chromium.android_webview.AwContentsClient
import org.chromium.android_webview.AwDevToolsServer
import org.chromium.android_webview.AwSettings
import org.chromium.android_webview.BuildConfig
import org.chromium.android_webview.shell.AwShellResourceProvider
import org.chromium.android_webview.test.AwTestContainerView
import org.chromium.base.CommandLine
import org.chromium.base.ContextUtils

@SuppressLint("SetJavaScriptEnabled")
@Suppress("ViewConstructor")
class AWChromium(context: Context, webViewClient: AwContentsClient = AWChromiumClient()) :
    FrameLayout(context) {
    private val awTestContainerView: AwTestContainerView = AwTestContainerView(context, true)
    private val awBrowserContext: AwBrowserContext
    private val awContents: AwContents

    var settings: AwSettings

    init {
        AwTestContainerView.installDrawFnFunctionTable(false)
        val sharedPreferences =
            context.getSharedPreferences(javaClass.simpleName, Context.MODE_PRIVATE)
        val nativePointer = AwBrowserContext.getDefault().nativePointer

        awBrowserContext = AwBrowserContext(sharedPreferences, nativePointer, true)
        settings = AwSettings(
            /* context = */ context,
            /* isAccessFromFileURLsGrantedByDefault = */ true,
            /* supportsLegacyQuirks = */ false,
            /* allowEmptyDocumentPersistence = */ false,
            /* allowGeolocationOnInsecureOrigins = */ false,
            /* doNotUpdateSelectionOnMutatingSelectionRange = */ false
        ).apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            useWideViewPort = true
            builtInZoomControls = true
            setSupportMultipleWindows(true)
            loadWithOverviewMode = true
            useWideViewPort = true
            setSupportZoom(true)
            displayZoomControls = false
            allowContentAccess = true
            allowFileAccess = true
            databaseEnabled = true
            setGeolocationEnabled(true)
            javaScriptCanOpenWindowsAutomatically = true
            allowFileAccessFromFileURLs = false
            allowUniversalAccessFromFileURLs = false
            saveFormData = true
            setAppCacheEnabled(true)
            databaseEnabled = true
        }
        awContents = AwContents(
            awBrowserContext,
            awTestContainerView,
            awTestContainerView.context,
            awTestContainerView.internalAccessDelegate,
            awTestContainerView.nativeDrawFunctorFactory,
            webViewClient,
            settings
        ).apply {
            isFocusableInTouchMode = true
            isFocusable = true
            isScrollbarFadingEnabled = true
            setNetworkAvailable(true)
        }

        awTestContainerView.initialize(awContents)
        addView(
            awTestContainerView,
            LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1f)
        )
    }

    @Keep
    fun loadUrl(url: String) {
        awContents.loadUrl(url)
    }

    @Keep
    fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>) {
        awContents.loadUrl(url, additionalHttpHeaders)
    }

    @Keep
    fun loadDataWithBaseURL(
        baseUrl: String?, data: String, mimeType: String?, encoding: String?, historyUrl: String?
    ) {
        awContents.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl)
    }

    @Keep
    fun evaluateJavascript(script: String) {
        awContents.evaluateJavaScript(script, null)
    }

    @Keep
    fun addJavascriptInterface(`object`: Any, name: String) {
        awContents.addJavascriptInterface(`object`, name)
    }

    @Keep
    fun removeJavascriptInterface(name: String) {
        awContents.removeJavascriptInterface(name)
    }

    @Keep
    fun reload() {
        awContents.reload()
    }

    @Keep
    fun stopLoading() {
        awContents.stopLoading()
    }

    @Keep
    fun canGoBack() = awContents.canGoBack()

    @Keep
    fun canGoForward() = awContents.canGoForward()

    @Keep
    fun goBack() = awContents.goBack()

    @Keep
    fun goForward() = awContents.goForward()

    @Keep
    fun clearView() {
        awContents.clearView()
    }

    @Keep
    fun clearCache(includeDiskFiles: Boolean) {
        awContents.clearCache(includeDiskFiles)
    }

    @Keep
    fun onResume() {
        awContents.onResume()
    }

    @Keep
    fun onPause() {
        awContents.onPause()
    }

    @Keep
    fun destroy() {
        awContents.destroy()
    }

    companion object {
        fun initialize(application: Application, flags: Array<String> = arrayOf()) {
            AwShellResourceProvider.registerResources(application)
            CommandLine.init(flags)
            ContextUtils.initApplicationContext(application)
            AwBrowserProcess.loadLibrary("AWChromium")
            AwBrowserProcess.start()
            if (BuildConfig.DEBUG) {
                AwDevToolsServer().setRemoteDebuggingEnabled(true)
            }
        }
    }

}