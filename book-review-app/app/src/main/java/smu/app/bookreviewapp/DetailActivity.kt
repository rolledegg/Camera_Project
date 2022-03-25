package smu.app.bookreviewapp

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast

class DetailActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val text = intent.getStringExtra("text")
        val webView : WebView = findViewById(R.id.webView)
        webView.loadUrl("file:///android_asset/web.html?webText=text")

        // 웹뷰의 자바 스크립트 기능을 활성화
        webView.settings.javaScriptEnabled = true
        // Android라는 이름을 명명해주고 JavascriptInterface를 추가
        webView.addJavascriptInterface(DetailActivity.WebAppInterface(this),"Android")

    }
    class WebAppInterface(private val mContext: Context){

        @JavascriptInterface
        fun showToast(toast: String){
            Toast.makeText(mContext,toast, Toast.LENGTH_SHORT).show()
        }

    }

}