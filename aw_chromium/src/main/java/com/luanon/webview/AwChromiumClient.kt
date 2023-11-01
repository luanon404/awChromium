package com.luanon.webview

import android.app.Activity
import android.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import com.google.android.material.textfield.TextInputLayout
import org.chromium.android_webview.AwGeolocationPermissions
import org.chromium.android_webview.JsPromptResultReceiver
import org.chromium.android_webview.JsResultReceiver
import org.chromium.android_webview.test.NullContentsClient
import java.net.MalformedURLException
import java.net.URL

open class AwChromiumClient(private val awContext: Activity) : NullContentsClient(awContext.mainLooper) {

    private var mCustomView: View? = null
    private var mCustomViewCallback: CustomViewCallback? = null
    private var mOriginalOrientation = 0
    private var mOriginalSystemUiVisibility = 0

    override fun handleJsAlert(url: String, message: String, receiver: JsResultReceiver) {
        var title = "From "
        try {
            val javaUrl = URL(url)
            title += javaUrl.protocol + "://" + javaUrl.host
            if (javaUrl.port != -1) {
                title += ":" + javaUrl.port
            }
        } catch (_: MalformedURLException) {
            title += url
        }
        AlertDialog.Builder(awContext).setTitle(title).setMessage(message).setPositiveButton(
            "OK"
        ) { _, _ -> receiver.confirm() }.create().show()
    }

    override fun handleJsConfirm(url: String, message: String, receiver: JsResultReceiver) {
        var title = "From "
        try {
            val javaUrl = URL(url)
            title += javaUrl.protocol + "://" + javaUrl.host
            if (javaUrl.port != -1) {
                title += ":" + javaUrl.port
            }
        } catch (_: MalformedURLException) {
            title += url
        }
        AlertDialog.Builder(awContext).setTitle(title).setMessage(message).setPositiveButton(
            "OK"
        ) { _, _ -> receiver.confirm() }.setNegativeButton(
            "Cancel"
        ) { _, _ -> receiver.cancel() }.create().show()
    }

    override fun handleJsPrompt(
        url: String, message: String, defaultValue: String, receiver: JsPromptResultReceiver
    ) {
        var title = "From "
        try {
            val javaUrl = URL(url)
            title += javaUrl.protocol + "://" + javaUrl.host
            if (javaUrl.port != -1) {
                title += ":" + javaUrl.port
            }
        } catch (_: MalformedURLException) {
            title += url
        }
        val textInputLayout = TextInputLayout(awContext)
        textInputLayout.setPadding(
            (19 * awContext.resources.displayMetrics.density).toInt(),
            0,
            (19 * awContext.resources.displayMetrics.density).toInt(),
            0
        )
        val input = EditText(awContext)
        input.hint = "Prompt"
        textInputLayout.addView(input)

        AlertDialog.Builder(awContext).setTitle(title).setMessage(message).setView(textInputLayout)
            .setPositiveButton(
                "OK"
            ) { _, _ -> receiver.confirm(input.text.toString()) }.create().show()
    }

    override fun onHideCustomView() {
        Log.i("hi555", "onHideCustomView")
        (awContext.window.decorView as FrameLayout).removeView(mCustomView)
        mCustomView = null
        awContext.window.decorView.systemUiVisibility = mOriginalSystemUiVisibility
        awContext.requestedOrientation = mOriginalOrientation
        mCustomViewCallback!!.onCustomViewHidden()
        mCustomViewCallback = null
    }

    override fun onShowCustomView(
        paramView: View, paramCustomViewCallback: CustomViewCallback
    ) {
        Log.i("hi555", "onShowCustomView")
        if (mCustomView != null) {
            onHideCustomView()
            return
        }
        mCustomView = paramView
        mOriginalSystemUiVisibility = awContext.window.decorView.systemUiVisibility
        mOriginalOrientation = awContext.requestedOrientation
        mCustomViewCallback = paramCustomViewCallback
        (awContext.window.decorView as FrameLayout).addView(mCustomView, FrameLayout.LayoutParams(-1, -1))
        awContext.window.decorView.systemUiVisibility = 3846 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }

    override fun onGeolocationPermissionsShowPrompt(
        origin: String, callback: AwGeolocationPermissions.Callback
    ) {
        callback.invoke(origin, false, false)
    }

}