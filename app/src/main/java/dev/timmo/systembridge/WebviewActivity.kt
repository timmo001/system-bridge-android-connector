package dev.timmo.systembridge

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class WebviewActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        val webviewMain = findViewById<WebView>(R.id.webviewMain)


        val url = Uri.Builder()
            .scheme("http")
            .authority("$hostname:$apiPort")
            .appendPath("app")
            .appendPath("settings")
            .appendQueryParameter("apiHost", hostname)
            .appendQueryParameter("apiKey", apiKey)
            .appendQueryParameter("apiPort", apiPort.toString())
            .appendQueryParameter("wsPort", websocketPort.toString())
            .build()
            .toString()

        Toast.makeText(this, "URL: $url", Toast.LENGTH_LONG).show()

        Log.v("MainActivity", "URL: $url")

        webviewMain.settings.javaScriptEnabled = true
        webviewMain.loadUrl(url)
    }
}
