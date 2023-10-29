package com.luanon.awchromium

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.luanon.webview.AwChromium
import com.luanon.webview.AwChromiumClient

class MainActivity : AppCompatActivity() {
    private lateinit var urlBar1: EditText
    private lateinit var urlBar2: EditText
    private lateinit var awContainerView1: FrameLayout
    private lateinit var awContainerView2: FrameLayout
    private lateinit var awChromium1: AwChromium
    private lateinit var awChromium2: AwChromium

    override fun onCreate(savedInstanceState: Bundle?) {
        AwChromium.initialize(
            this, arrayOf("--disable-site-isolation-trials", "--disable-web-security")
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlBar1 = findViewById(R.id.url_bar_1)
        urlBar2 = findViewById(R.id.url_bar_2)
        awContainerView1 = findViewById(R.id.webview_container_1)
        awContainerView2 = findViewById(R.id.webview_container_2)

        awChromium1 = AwChromium(this)
        awChromium1.awSettings.apply {
            javaScriptEnabled = false
        }
        awChromium1.awChromiumClient = object : AwChromiumClient(this) {
            override fun shouldOverrideUrlLoading(request: AwWebResourceRequest?): Boolean {
                Log.i(Utils.TAG, "WV1-Redirect: " + request!!.url)
                awChromium1.loadUrl(request.url!!)
                return true
            }

            override fun onPageFinished(url: String?) {
                super.onPageFinished(url)
                urlBar1.setText(url)
            }
        }
        awContainerView1.addView(awChromium1)

        val refreshButton1 = findViewById<Button>(R.id.refresh_button_1)
        val backButton1 = findViewById<Button>(R.id.back_button_1)
        val forwardButton1 = findViewById<Button>(R.id.forward_button_1)

        awChromium1.loadUrl("https://www.enable-javascript.com/")

        refreshButton1.setOnClickListener {
            val url = urlBar1.text.toString()
            awChromium1.loadUrl(url)
        }

        backButton1.setOnClickListener {
            if (awChromium1.canGoBack()) {
                awChromium1.goBack()
            }
        }

        forwardButton1.setOnClickListener {
            if (awChromium1.canGoForward()) {
                awChromium1.goForward()
            }
        }

        awChromium2 = AwChromium(this)
        awChromium2.awChromiumClient = object : AwChromiumClient(this) {
            override fun shouldOverrideUrlLoading(request: AwWebResourceRequest?): Boolean {
                Log.i(Utils.TAG, "WV2-Redirect: " + request!!.url)
                awChromium2.loadUrl(request.url!!)
                return true
            }

            override fun onPageFinished(url: String?) {
                super.onPageFinished(url)
                urlBar2.setText(url)
                awChromium2.evaluateJavascript("javascript:(function () { var script = document.createElement('script'); script.src=\"https://cdn.jsdelivr.net/npm/eruda\"; document.body.append(script); script.onload = function () { eruda.init(); } })();")
            }
        }
        awContainerView2.addView(awChromium2)

        val refreshButton2 = findViewById<Button>(R.id.refresh_button_2)
        val backButton2 = findViewById<Button>(R.id.back_button_2)
        val forwardButton2 = findViewById<Button>(R.id.forward_button_2)

        awChromium2.loadUrl("https://recaptcha-demo.appspot.com/recaptcha-v2-checkbox.php")

        refreshButton2.setOnClickListener {
            val url = urlBar2.text.toString()
            if (url.startsWith("javascript:")) {
                val script = url.replace("javascript:", "")
                Log.i(Utils.TAG, script)
                awChromium2.evaluateJavascript(script)
            } else if (url.startsWith("testIframe")) {
                awChromium2.evaluateJavascript("console.log(document.querySelector(\"div[class*=g-recaptcha]\").querySelector(\"iframe[title*=reCAPTCHA]\").contentWindow.document.querySelector(\"label\").textContent)")
            } else {
                awChromium2.loadUrl(url)
            }
        }

        backButton2.setOnClickListener {
            if (awChromium2.canGoBack()) {
                awChromium2.goBack()
            }
        }

        forwardButton2.setOnClickListener {
            if (awChromium2.canGoForward()) {
                awChromium2.goForward()
            }
        }
    }
}
