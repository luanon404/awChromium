package com.luanon.awchromium

import android.app.Application
import android.content.Context
import com.luanon.webview.AwChromium

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AwChromium.initialize(this)
    }

    override fun attachBaseContext(context: Context?) {
        super.attachBaseContext(context)
        AwChromium.initializeBase(
            this,
            arrayOf("--disable-site-isolation-trials", "--disable-web-security")
        )
    }

}