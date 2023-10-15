package com.luanon.awchromium

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.luanon.webview.AwChromium
import com.luanon.webview.AwChromiumClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val awContainerView1 = findViewById<FrameLayout>(R.id.webview_container_1)
        val awContainerView2 = findViewById<FrameLayout>(R.id.webview_container_2)

        val awChromium1 = AwChromium(this)
        awChromium1.awSettings.apply {
            javaScriptEnabled = false
        }
        awChromium1.loadUrl("https://www.enable-javascript.com/")
        awContainerView1.addView(
            awChromium1, LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
            )
        )

        val awChromium2 = AwChromium(this)
        awChromium2.awChromiumClient = object : AwChromiumClient() {
            override fun shouldOverrideUrlLoading(request: AwWebResourceRequest): Boolean {
                Log.i(Utils.TAG, "Redirect: " + request.url)
                return true
            }
        }
        awChromium2.loadUrl("https://www.enable-javascript.com/")
        awContainerView2.addView(
            awChromium2, LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
            )
        )
    }
}
