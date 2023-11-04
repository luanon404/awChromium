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
class AwChromium(awContext: Activity, allowHardwareAcceleration: Boolean = true) :
    AwTestContainerView(awContext, allowHardwareAcceleration) {
    private val awBrowserContext: AwBrowserContext =
        AwBrowserContext(AwBrowserContext.getDefault().nativeBrowserContextPointer)
    private var awPrivateChromiumClient: AwChromiumClient

    @get:Keep
    @set:Keep
    var awChromiumClient: AwChromiumClient
        get() = awPrivateChromiumClient
        set(value) {
            awPrivateChromiumClient = value
            this.initialize(
                AwContents(
                    awBrowserContext,
                    this,
                    this.context,
                    this.internalAccessDelegate,
                    this.nativeDrawFunctorFactory,
                    awPrivateChromiumClient,
                    this.awContents.settings
                )
            )
        }

    init {
        awPrivateChromiumClient = AwChromiumClient(awContext)
        this.initialize(
            AwContents(
                awBrowserContext,
                this,
                this.context,
                this.internalAccessDelegate,
                this.nativeDrawFunctorFactory,
                awPrivateChromiumClient,
                AwSettings(
                    context, true, false, false, false, false
                )
            )
        )
        this.awContents.settings.allowContentAccess = true
        this.awContents.settings.allowFileAccess = true
        this.awContents.settings.allowFileAccessFromFileURLs = false
        this.awContents.settings.allowUniversalAccessFromFileURLs = false
        this.awContents.settings.builtInZoomControls = true
        this.awContents.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        this.awContents.settings.databaseEnabled = true
        this.awContents.settings.displayZoomControls = false
        this.awContents.settings.domStorageEnabled = true
        this.awContents.settings.javaScriptCanOpenWindowsAutomatically = true
        this.awContents.settings.javaScriptEnabled = true
        this.awContents.settings.layoutAlgorithm = AwSettings.LAYOUT_ALGORITHM_TEXT_AUTOSIZING
        this.awContents.settings.loadWithOverviewMode = true
        this.awContents.settings.mediaPlaybackRequiresUserGesture = false
        this.awContents.settings.saveFormData = true
        this.awContents.settings.setGeolocationEnabled(false)
        this.awContents.settings.setSupportMultipleWindows(true)
        this.awContents.settings.setSupportZoom(true)
        this.awContents.settings.useWideViewPort = true
    }

    companion object {

        fun initialize(context: Context, flags: Array<String> = arrayOf()) {
            CommandLine.init(flags)
            AwShellResourceProvider.registerResources(context)
            AwBrowserProcess.loadLibrary(null)
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
