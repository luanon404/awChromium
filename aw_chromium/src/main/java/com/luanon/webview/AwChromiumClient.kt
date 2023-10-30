package com.luanon.webview

import android.app.Activity
import android.app.AlertDialog
import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.EditText
import android.widget.FrameLayout
import com.google.android.material.textfield.TextInputLayout
import org.chromium.android_webview.AwGeolocationPermissions
import org.chromium.android_webview.JsPromptResultReceiver
import org.chromium.android_webview.JsResultReceiver
import org.chromium.android_webview.test.NullContentsClient
import java.net.MalformedURLException
import java.net.URL

open class AwChromiumClient(private val context: Activity) : NullContentsClient() {

    private var mCustomView: View? = null

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
        AlertDialog.Builder(context).setTitle(title).setMessage(message).setPositiveButton(
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
        AlertDialog.Builder(context).setTitle(title).setMessage(message).setPositiveButton(
            "OK"
        ) { _, _ -> receiver.confirm() }.setNegativeButton(
            "Cancel"
        ) { _, _ -> receiver.cancel() }.create().show()
    }

    override fun handleJsPrompt(
        url: String,
        message: String,
        defaultValue: String,
        receiver: JsPromptResultReceiver
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
        val textInputLayout = TextInputLayout(context)
        textInputLayout.setPadding(
            (19 * context.resources.displayMetrics.density).toInt(),
            0,
            (19 * context.resources.displayMetrics.density).toInt(),
            0
        )
        val input = EditText(context)
        input.hint = "Prompt"
        textInputLayout.addView(input)

        AlertDialog.Builder(context).setTitle(title).setMessage(message).setView(textInputLayout).setPositiveButton(
            "OK"
        ) { _, _ -> receiver.confirm(input.text.toString()) }.create().show()
    }

    override fun onShowCustomView(view: View, callback: CustomViewCallback) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            context.window.insetsController!!.hide(android.R.style.Theme_NoTitleBar_Fullscreen)
        } else {
            context.window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        context.window.addContentView(
            view, FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                Gravity.CENTER
            )
        )
        mCustomView = view
    }

    override fun onHideCustomView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            context.window.insetsController!!.show(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
        } else {
            context.window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        val decorView = context.window.decorView as FrameLayout
        decorView.removeView(mCustomView)
        mCustomView = null
    }

    override fun onGeolocationPermissionsShowPrompt(
        origin: String, callback: AwGeolocationPermissions.Callback
    ) {
        callback.invoke(origin, false, false)
    }

}