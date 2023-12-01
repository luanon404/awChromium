package aw.chromium.demo

import android.graphics.Color
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.luanon.webview.AwChromium
import com.luanon.webview.AwChromiumClient

class MainActivity : AppCompatActivity() {
    private lateinit var awChromium: AwChromium

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AwChromium.initialize(
            this, arrayOf("--disable-site-isolation-trials", "--disable-web-security")
        )
        setContentView(R.layout.activity_main)

        val awContainerView = findViewById<FrameLayout>(R.id.webview_container)
        val urlBar = findViewById<AppCompatEditText>(R.id.url_bar)
        val refreshButton = findViewById<AppCompatButton>(R.id.refresh_button)
        val backButton = findViewById<AppCompatButton>(R.id.back_button)
        val forwardButton = findViewById<AppCompatButton>(R.id.forward_button)

        awChromium = AwChromium(this)
        awChromium.awContents.setBackgroundColor(Color.WHITE)
        awChromium.awChromiumClient = object : AwChromiumClient(this) {
            override fun shouldOverrideUrlLoading(request: AwWebResourceRequest?): Boolean {
                awChromium.awContents.loadUrl(request!!.url)
                return true
            }

            override fun onPageFinished(url: String?) {
                super.onPageFinished(url)
                urlBar.setText(url)
                awChromium.awContents.evaluateJavaScript(
                    "javascript:(function(){var script=document.createElement(\"script\");script.src=\"https://cdn.jsdelivr.net/npm/eruda\";document.body.append(script);script.onload=function(){eruda.init();console.log(document.querySelector(\"div[class*=g-recaptcha]\").querySelector(\"iframe[title*=reCAPTCHA]\").contentWindow.document.querySelector(\"label\").textContent);}})();",
                    null
                )
            }
        }
        awContainerView.addView(awChromium)

        awChromium.awContents.loadUrl("https://recaptcha-demo.appspot.com/recaptcha-v2-checkbox.php")

        refreshButton.setOnClickListener {
            val url = urlBar.text.toString()
            if (url.startsWith("javascript:")) {
                val script = url.replace("javascript:", "")
                awChromium.awContents.evaluateJavaScript(script, null)
                urlBar.setText(awChromium.awContents.lastCommittedUrl)
            } else {
                awChromium.awContents.loadUrl(url)
            }
        }

        refreshButton.setOnEditorActionListener { view: TextView?, actionId: Int, event: KeyEvent? ->
            if ((actionId != EditorInfo.IME_ACTION_GO) && ((event == null) || (event.keyCode != KeyEvent.KEYCODE_ENTER) || (event.action != KeyEvent.ACTION_DOWN))) {
                return@setOnEditorActionListener false
            }
            val url: String = view!!.text.toString()
            awChromium.awContents.loadUrl(url)
            view.clearFocus()
            awChromium.requestFocus()
            true
        }

        backButton.setOnClickListener {
            if (awChromium.awContents.canGoBack()) {
                awChromium.awContents.goBack()
            }
        }

        forwardButton.setOnClickListener {
            if (awChromium.awContents.canGoForward()) {
                awChromium.awContents.goForward()
            }
        }

    }

    override fun onDestroy() {
        awChromium.destroy()
        super.onDestroy()
    }
}