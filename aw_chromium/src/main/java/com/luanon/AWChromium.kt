package com.luanon

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.widget.FrameLayout
import android.widget.LinearLayout
import org.chromium.android_webview.AwBrowserContext
import org.chromium.android_webview.AwBrowserProcess
import org.chromium.android_webview.AwContents
import org.chromium.android_webview.AwContentsClient
import org.chromium.android_webview.AwDevToolsServer
import org.chromium.android_webview.AwSettings
import org.chromium.android_webview.BuildConfig
import org.chromium.android_webview.shell.AwShellResourceProvider
import org.chromium.android_webview.test.AwTestContainerView
import org.chromium.android_webview.test.NullContentsClient
import org.chromium.base.CommandLine
import org.chromium.base.ContextUtils

@SuppressLint("SetJavaScriptEnabled")
@Suppress("ViewConstructor")
class AWChromium(context: Context, webViewClient: AwContentsClient = NullContentsClient()) :
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
        settings = AwSettings(context, true, false, false, false, false).apply {
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
        val params =
            LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1f)
        addView(awTestContainerView, params)
    }

    fun loadUrl(url: String) {
        awContents.loadUrl(url)
    }

    fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>) {
        awContents.loadUrl(url, additionalHttpHeaders)
    }

    fun loadDataWithBaseURL(
        baseUrl: String?,
        data: String,
        mimeType: String?,
        encoding: String?,
        historyUrl: String?
    ) {
        awContents.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl)
    }

    fun evaluateJavascript(script: String) {
        awContents.evaluateJavaScript(script, null)
    }

    fun addJavascriptInterface(`object`: Any, name: String) {
        awContents.addJavascriptInterface(`object`, name)
    }

    fun removeJavascriptInterface(name: String) {
        awContents.removeJavascriptInterface(name)
    }

    fun reload() {
        awContents.reload()
    }

    fun stopLoading() {
        awContents.stopLoading()
    }

    fun canGoBack() = awContents.canGoBack()

    fun canGoForward() = awContents.canGoForward()

    fun goBack() = awContents.goBack()

    fun goForward() = awContents.goForward()

    fun clearView() {
        awContents.clearView()
    }

    fun clearCache(includeDiskFiles: Boolean) {
        awContents.clearCache(includeDiskFiles)
    }

    fun onResume() {
        awContents.onResume()
    }

    fun onPause() {
        awContents.onPause()
    }

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