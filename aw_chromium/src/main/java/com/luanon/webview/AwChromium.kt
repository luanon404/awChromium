package com.luanon.webview

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.widget.FrameLayout
import androidx.annotation.Keep
import org.chromium.android_webview.AwBrowserContext
import org.chromium.android_webview.AwBrowserProcess
import org.chromium.android_webview.AwContents
import org.chromium.android_webview.AwDevToolsServer
import org.chromium.android_webview.AwLocaleConfig
import org.chromium.android_webview.AwSettings
import org.chromium.android_webview.BuildConfig
import org.chromium.base.CommandLine
import org.chromium.base.ContextUtils
import org.chromium.base.PathUtils
import org.chromium.ui.base.ResourceBundle

@SuppressLint("SetJavaScriptEnabled")
@Suppress("ViewConstructor")
class AwChromium(context: Context) : FrameLayout(context) {
    private val awContainerView = AwContainerView(context, true)
    private val awBrowserContext: AwBrowserContext
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
        val sharedPreferences =
            context.getSharedPreferences(javaClass.simpleName, Context.MODE_PRIVATE)
        val nativePointer = AwBrowserContext.getDefault().nativePointer

        awBrowserContext = AwBrowserContext(sharedPreferences, nativePointer, true)
        awPrivateChromiumClient = AwChromiumClient()
        awPrivateSettings = AwSettings(
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
            awContainerView,
            awContainerView.context,
            awContainerView.internalAccessDelegate,
            awContainerView.nativeDrawFunctorFactory,
            awPrivateChromiumClient,
            awPrivateSettings
        ).apply {
            isFocusableInTouchMode = true
            isFocusable = true
            isScrollbarFadingEnabled = true
            setNetworkAvailable(true)
        }
        awContainerView.initialize(awContents)
        addView(
            awContainerView,
            LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        )
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
            awPrivateChromiumClient,
            awPrivateSettings
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
        fun initialize(application: Application) {
            AwShellResourceProvider.registerResources(application)
            AwBrowserProcess.loadLibrary(null)
            AwBrowserProcess.start()
            if (BuildConfig.DEBUG) {
                AwDevToolsServer().setRemoteDebuggingEnabled(true)
            }
            /** Initialize draw function */
            AwContainerView.installDrawFnFunctionTable(false)
            AwContainerView(application, true)
        }

        fun initializeBase(context: Context?, flags: Array<String> = arrayOf()) {
            ContextUtils.initApplicationContext(context)
            PathUtils.setPrivateDataDirectorySuffix("webview", "WebView")
            CommandLine.init(flags)
            ResourceBundle.setAvailablePakLocales(AwLocaleConfig.getWebViewSupportedPakLocales())
        }
    }

}