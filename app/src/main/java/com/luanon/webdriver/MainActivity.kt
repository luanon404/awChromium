package com.luanon.webdriver

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.luanon.webview.AwChromium
import com.luanon.webview.AwChromiumClient
import org.chromium.android_webview.test.AwTestContainerView

class MainActivity : AppCompatActivity() {
    private lateinit var urlBar1: EditText
    private lateinit var urlBar2: EditText
    private lateinit var awContainerView1: FrameLayout
    private lateinit var awContainerView2: FrameLayout
    private lateinit var awChromium1: AwChromium
    private lateinit var awChromium2: AwChromium

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AwChromium.initialize(
            this, arrayOf("--disable-site-isolation-trials", "--disable-web-security")
        )
        setContentView(R.layout.activity_main)

        urlBar1 = findViewById(R.id.url_bar_1)
        urlBar2 = findViewById(R.id.url_bar_2)
        awContainerView1 = findViewById(R.id.webview_container_1)
        awContainerView2 = findViewById(R.id.webview_container_2)

        TODO(
            "This cause content not draw\n" +
                    "Create this 2 times can broken webview\n" +
                    "Maybe try to create just 1 then clone it or something?" +
                    "Or maybe try to create 2 times but with different context?" +
                    "Or maybe service?"
        )
        AwTestContainerView(this, true)

//        awChromium1 = AwChromium(this)
//        awChromium1.awContents.settings.apply {
//            javaScriptEnabled = false
//        }
//        awChromium1.awChromiumClient = object : AwChromiumClient(this) {
//            override fun shouldOverrideUrlLoading(request: AwWebResourceRequest): Boolean {
//                Log.i(Utils.TAG, "WV1-Redirect: " + request.url)
//                awChromium1.awContents.loadUrl(request.url)
//                return true
//            }
//
//            override fun onPageFinished(url: String) {
//                super.onPageFinished(url)
//                urlBar1.setText(url)
//            }
//        }
//        awContainerView1.addView(awChromium1)
//        awChromium1.requestFocus()
//
        val refreshButton1 = findViewById<Button>(R.id.refresh_button_1)
        val backButton1 = findViewById<Button>(R.id.back_button_1)
        val forwardButton1 = findViewById<Button>(R.id.forward_button_1)

//        awChromium1.awContents.loadUrl("https://www.enable-javascript.com/")

        refreshButton1.setOnClickListener {
            val url = urlBar1.text.toString()
            awChromium1.awContents.loadUrl(url)
        }

        refreshButton1.setOnEditorActionListener { view: TextView?, actionId: Int, event: KeyEvent? ->
            if ((actionId != EditorInfo.IME_ACTION_GO) && ((event == null) || (event.keyCode != KeyEvent.KEYCODE_ENTER) || (event.action != KeyEvent.ACTION_DOWN))) {
                return@setOnEditorActionListener false
            }
            val url: String = view!!.text.toString()
            awChromium1.awContents.loadUrl(url)
            view.clearFocus()
            awChromium1.requestFocus()
            true
        }


        backButton1.setOnClickListener {
            if (awChromium1.awContents.canGoBack()) {
                awChromium1.awContents.goBack()
            }
        }

        forwardButton1.setOnClickListener {
            if (awChromium1.awContents.canGoForward()) {
                awChromium1.awContents.goForward()
            }
        }

        awChromium2 = AwChromium(this)
        awChromium2.awChromiumClient = object : AwChromiumClient(this) {
            override fun shouldOverrideUrlLoading(request: AwWebResourceRequest?): Boolean {
                Log.i(Utils.TAG, "WV2-Redirect: " + request!!.url)
                awChromium2.awContents.loadUrl(request.url)
                return true
            }

            override fun onPageFinished(url: String?) {
                super.onPageFinished(url)
                urlBar2.setText(url)
                awChromium2.awContents.evaluateJavaScript(
                    "javascript:(function () { var script = document.createElement('script'); script.src=\"https://cdn.jsdelivr.net/npm/eruda\"; document.body.append(script); script.onload = function () { eruda.init(); } })();",
                    null
                )
            }
        }
        awContainerView2.addView(awChromium2)

        val refreshButton2 = findViewById<Button>(R.id.refresh_button_2)
        val backButton2 = findViewById<Button>(R.id.back_button_2)
        val forwardButton2 = findViewById<Button>(R.id.forward_button_2)

//        awChromium2.awContents.loadUrl("https://recaptcha-demo.appspot.com/recaptcha-v2-checkbox.php")
        awChromium2.awContents.loadUrl("https://animevietsub.fan/phim/cong-chien-tranh-a1050/tap-08-45017.html")

        refreshButton2.setOnClickListener {
            val url = urlBar2.text.toString()
            if (url.startsWith("javascript:")) {
                val script = url.replace("javascript:", "")
                Log.i(Utils.TAG, script)
                awChromium2.awContents.evaluateJavaScript(script, null)
            } else if (url.startsWith("testIframe")) {
                awChromium2.awContents.evaluateJavaScript(
                    "console.log(document.querySelector(\"div[class*=g-recaptcha]\").querySelector(\"iframe[title*=reCAPTCHA]\").contentWindow.document.querySelector(\"label\").textContent)",
                    null
                )
            } else {
                awChromium2.awContents.loadUrl(url)
            }
        }

        refreshButton2.setOnEditorActionListener { view: TextView?, actionId: Int, event: KeyEvent? ->
            if ((actionId != EditorInfo.IME_ACTION_GO) && ((event == null) || (event.keyCode != KeyEvent.KEYCODE_ENTER) || (event.action != KeyEvent.ACTION_DOWN))) {
                return@setOnEditorActionListener false
            }
            val url: String = view!!.text.toString()
            awChromium2.awContents.loadUrl(url)
            view.clearFocus()
            awChromium2.requestFocus()
            true
        }

        backButton2.setOnClickListener {
            if (awChromium2.awContents.canGoBack()) {
                awChromium2.awContents.goBack()
            }
        }

        forwardButton2.setOnClickListener {
            if (awChromium2.awContents.canGoForward()) {
                awChromium2.awContents.goForward()
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        awChromium1.destroy()
        awChromium2.destroy()
    }
}
