package com.luanon.webview

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.webkit.WebSettings
import androidx.annotation.Keep
import org.chromium.android_webview.AwBrowserContext
import org.chromium.android_webview.AwBrowserProcess
import org.chromium.android_webview.AwContents
import org.chromium.android_webview.AwLocaleConfig
import org.chromium.android_webview.AwSettings
import org.chromium.android_webview.shell.AwShellResourceProvider
import org.chromium.android_webview.test.AwTestContainerView
import org.chromium.base.CommandLine
import org.chromium.base.ContextUtils
import org.chromium.base.PathUtils
import org.chromium.ui.base.ResourceBundle

@SuppressLint("SetJavaScriptEnabled", "ViewConstructor")
class AwChromium(awContext: Activity, allowHardwareAcceleration: Boolean = true) : AwTestContainerView(awContext, allowHardwareAcceleration) {
    private val awBrowserContext: AwBrowserContext = AwBrowserContext(AwBrowserContext.getDefault().nativeBrowserContextPointer)
    private var awPrivateSettings: AwSettings
    private var awPrivateChromiumClient: AwChromiumClient

    @get:Keep
    @set:Keep
    var awChromiumClient: AwChromiumClient
        get() = awPrivateChromiumClient
        set(value) {
            awPrivateChromiumClient = value
            this.initialize(AwContents(
                awBrowserContext,
                this,
                this.context,
                this.internalAccessDelegate,
                this.nativeDrawFunctorFactory,
                awPrivateChromiumClient,
                awPrivateSettings
            ))
        }

    init {
        awPrivateChromiumClient = AwChromiumClient(awContext)
        awPrivateSettings = AwSettings(
            context, true, false, false, false, false
        )

        // Required for WebGL conformance tests.
        awPrivateSettings.allowContentAccess = true
        awPrivateSettings.allowFileAccess = true
        awPrivateSettings.allowFileAccessFromFileURLs = true
        awPrivateSettings.allowUniversalAccessFromFileURLs = true

        awPrivateSettings.mediaPlaybackRequiresUserGesture = false
        // Allow zoom and fit contents to screen
        awPrivateSettings.builtInZoomControls = true
        awPrivateSettings.displayZoomControls = false
        awPrivateSettings.useWideViewPort = true
        awPrivateSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        awPrivateSettings.loadWithOverviewMode = true
        awPrivateSettings.layoutAlgorithm = AwSettings.LAYOUT_ALGORITHM_TEXT_AUTOSIZING

//            .apply {
//            allowContentAccess = true
//            allowFileAccess = true
//            allowFileAccessFromFileURLs = false
//            allowUniversalAccessFromFileURLs = false
//            builtInZoomControls = true
//            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
//            databaseEnabled = true
//            displayZoomControls = false
//            domStorageEnabled = true
//            javaScriptCanOpenWindowsAutomatically = true
//            javaScriptEnabled = true
//            layoutAlgorithm = AwSettings.LAYOUT_ALGORITHM_TEXT_AUTOSIZING
//            loadWithOverviewMode = true
//            mediaPlaybackRequiresUserGesture = false
//            saveFormData = true
//            setGeolocationEnabled(false)
//            setSupportMultipleWindows(true)
//            setSupportZoom(true)
//            useWideViewPort = true
//        }
//            .apply {
//            isFocusableInTouchMode = true
//            isFocusable = true
//            isScrollbarFadingEnabled = true
//            setNetworkAvailable(true)
//        }
        this.initialize(AwContents(
            awBrowserContext,
            this,
            this.context,
            this.internalAccessDelegate,
            this.nativeDrawFunctorFactory,
            awPrivateChromiumClient,
            awPrivateSettings
        ))
        this.awContents.settings.javaScriptEnabled = true
    }

    companion object {
        fun initialize(context: Context, flags: Array<String> = arrayOf()) {
            CommandLine.init(flags)
            AwShellResourceProvider.registerResources(context)
            AwBrowserProcess.loadLibrary(null)
        }

        fun abc() {
            AwBrowserProcess.start()
            /** Initialize draw function */
            val supportedModels: Array<String?> = arrayOf("Pixel 6", "Pixel 6 Pro")
            val useVulkan = supportedModels.contains(Build.MODEL)
            installDrawFnFunctionTable(useVulkan)
        }

        fun initializeBase(context: Context?) {
            ContextUtils.initApplicationContext(context)
            PathUtils.setPrivateDataDirectorySuffix("webview", "WebView")
            ResourceBundle.setAvailablePakLocales(AwLocaleConfig.getWebViewSupportedPakLocales())
        }
    }

}
