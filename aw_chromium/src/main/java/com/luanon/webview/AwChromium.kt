package com.luanon.webview

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.widget.FrameLayout
import androidx.annotation.Keep
import org.chromium.android_webview.AwBrowserContext
import org.chromium.android_webview.AwBrowserProcess
import org.chromium.android_webview.AwContents
import org.chromium.android_webview.AwDevToolsServer
import org.chromium.android_webview.AwLocaleConfig
import org.chromium.android_webview.AwSettings
import org.chromium.android_webview.BuildConfig
import org.chromium.android_webview.shell.AwShellResourceProvider
import org.chromium.android_webview.test.AwTestContainerView
import org.chromium.base.CommandLine
import org.chromium.base.ContextUtils
import org.chromium.base.PathUtils
import org.chromium.ui.base.ResourceBundle

@SuppressLint("SetJavaScriptEnabled")
@Suppress("ViewConstructor")
class AwChromium(context: Context) : FrameLayout(context) {
    private val awContainerView = AwTestContainerView(context, true)
    private val awBrowserContext: AwBrowserContext =
        AwBrowserContext(AwBrowserContext.getDefault().nativeBrowserContextPointer)
    private var awContents: AwContents
    private var awPrivateSettings: AwSettings
    private var awPrivateChromiumClient: AwChromiumClient

    @get:Keep
    @set:Keep
    var awSettings: AwSettings
        get() = awPrivateSettings
        set(value) {
            awPrivateSettings = value
            privateReInit()
        }

    @get:Keep
    @set:Keep
    var awChromiumClient: AwChromiumClient
        get() = awPrivateChromiumClient
        set(value) {
            awPrivateChromiumClient = value
            privateReInit()
        }

    init {
        awPrivateChromiumClient = AwChromiumClient()
        awPrivateSettings = AwSettings(
            context, true, false, false, false, false
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
            databaseEnabled = true
            layoutAlgorithm = AwSettings.LAYOUT_ALGORITHM_TEXT_AUTOSIZING
        }
        awContents = AwContents(
            awBrowserContext,
            awContainerView,
            awContainerView.context,
            awContainerView.internalAccessDelegate,
            awContainerView.nativeDrawFunctorFactory,
            awChromiumClient,
            awSettings
        ).apply {
            isFocusableInTouchMode = true
            isFocusable = true
            isScrollbarFadingEnabled = true
            setNetworkAvailable(true)
        }
        awContainerView.initialize(awContents)
        awContainerView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1)
        awContainerView.requestFocus()
    }

    @Keep
    private fun privateReInit() {
        awContents = AwContents(
            awBrowserContext,
            awContainerView,
            awContainerView.context,
            awContainerView.internalAccessDelegate,
            awContainerView.nativeDrawFunctorFactory,
            awChromiumClient,
            awSettings
        ).apply {
            isFocusableInTouchMode = true
            isFocusable = true
            isScrollbarFadingEnabled = true
            setNetworkAvailable(true)
        }
        awContainerView.initialize(awContents)
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
        fun initialize(context: Context, flags: Array<String> = arrayOf()) {
            CommandLine.init(flags)
            /** Important */
            AwShellResourceProvider.registerResources(context)
            AwBrowserProcess.loadLibrary(null)
            AwBrowserProcess.start()
            if (BuildConfig.DEBUG) {
                AwDevToolsServer().setRemoteDebuggingEnabled(true)
            }
            /** Initialize draw function */
            val supportedModels: Array<String?> = arrayOf("Pixel 6", "Pixel 6 Pro")
            val useVulkan = supportedModels.contains(Build.MODEL)
            AwTestContainerView.installDrawFnFunctionTable(useVulkan)
            AwTestContainerView(context, true)
        }

        fun initializeBase(context: Context?) {
            ContextUtils.initApplicationContext(context)
            PathUtils.setPrivateDataDirectorySuffix("webview", "WebView")
            ResourceBundle.setAvailablePakLocales(AwLocaleConfig.getWebViewSupportedPakLocales())
        }
    }

}