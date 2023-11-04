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
import org.chromium.android_webview.permission.AwPermissionRequest
import org.chromium.android_webview.test.NullContentsClient
import java.net.MalformedURLException
import java.net.URL

open class AwChromiumClient(private val awContext: Activity) :
    NullContentsClient(awContext.mainLooper) {

    override fun handleJsAlert(url: String?, message: String?, receiver: JsResultReceiver?) {
        super.handleJsAlert(url, message, receiver)
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
        ) { _, _ -> receiver!!.confirm() }.create().show()
    }

    override fun handleJsConfirm(url: String?, message: String?, receiver: JsResultReceiver?) {
        super.handleJsConfirm(url, message, receiver)
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
        ) { _, _ -> receiver!!.confirm() }.setNegativeButton(
            "Cancel"
        ) { _, _ -> receiver!!.cancel() }.create().show()
    }

    override fun handleJsPrompt(
        url: String?, message: String?, defaultValue: String?, receiver: JsPromptResultReceiver?
    ) {
        super.handleJsPrompt(url, message, defaultValue, receiver)
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
            ) { _, _ -> receiver!!.confirm(input.text.toString()) }.create().show()
    }

    override fun onPermissionRequest(awPermissionRequest: AwPermissionRequest?) {
        Log.i("hi555", awPermissionRequest!!.resources.toString())
        awPermissionRequest.grant()
    }

    override fun onGeolocationPermissionsShowPrompt(
        origin: String?, callback: AwGeolocationPermissions.Callback?
    ) {
        super.onGeolocationPermissionsShowPrompt(origin, callback)
        callback!!.invoke(origin, false, false)
    }

}