package com.luanon.webview

import android.app.Activity
import android.app.AlertDialog
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import org.chromium.android_webview.JsPromptResultReceiver
import org.chromium.android_webview.JsResultReceiver
import org.chromium.android_webview.test.NullContentsClient
import java.net.URL

open class AwChromiumClient(private val awContext: Activity) :
    NullContentsClient(awContext.mainLooper) {

    override fun handleJsAlert(url: String?, message: String?, receiver: JsResultReceiver?) {
        super.handleJsAlert(url, message, receiver)
        val javaUrl = runCatching { URL(url) }.getOrNull()
        val title =
            "From ${javaUrl?.let { "${it.protocol}://${it.host}${if (it.port != -1) ":${it.port}" else ""}" } ?: url}"
        AlertDialog.Builder(awContext)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { _, _ -> receiver?.confirm() }
            .create()
            .show()
    }

    override fun handleJsConfirm(url: String?, message: String?, receiver: JsResultReceiver?) {
        val javaUrl = runCatching { URL(url) }.getOrNull()
        val title =
            "From ${javaUrl?.let { "${it.protocol}://${it.host}${if (it.port != -1) ":${it.port}" else ""}" } ?: url}"
        AlertDialog.Builder(awContext)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { _, _ -> receiver?.confirm() }
            .setNegativeButton("Cancel") { _, _ -> receiver?.cancel() }
            .create()
            .show()
    }

    override fun handleJsPrompt(
        url: String?, message: String?, defaultValue: String?, receiver: JsPromptResultReceiver?
    ) {
        super.handleJsPrompt(url, message, defaultValue, receiver)
        val javaUrl = runCatching { URL(url) }.getOrNull()
        val title =
            "From ${javaUrl?.let { "${it.protocol}://${it.host}${if (it.port != -1) ":${it.port}" else ""}" } ?: url}"
        val textInputLayout = TextInputLayout(awContext).apply {
            setPadding(
                (19 * awContext.resources.displayMetrics.density).toInt(),
                0,
                (19 * awContext.resources.displayMetrics.density).toInt(),
                0
            )
        }
        val input = EditText(awContext).apply {
            hint = "Prompt"
            textInputLayout.addView(this)
        }

        AlertDialog.Builder(awContext)
            .setTitle(title)
            .setMessage(message)
            .setView(textInputLayout)
            .setPositiveButton("OK") { _, _ -> receiver?.confirm(input.text.toString()) }
            .create()
            .show()
    }

}