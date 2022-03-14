package smu.app.simplewegapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled", "JavascriptInterface")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button)
        val editText : EditText = findViewById(R.id.editText)
        val intent =Intent(this,WebViewActivity::class.java)


        button.setOnClickListener {
            intent.putExtra("text",editText.text.toString())
            startActivity(intent)
        }


    }


}