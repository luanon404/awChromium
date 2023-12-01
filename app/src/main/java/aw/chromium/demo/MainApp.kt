package aw.chromium.demo

import android.app.Application
import android.content.Context
import com.luanon.webview.AwChromium

class MainApp : Application() {

    override fun attachBaseContext(context: Context?) {
        super.attachBaseContext(context)
        AwChromium.initializeBase(this)
    }

}