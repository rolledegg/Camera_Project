package smu.app.lottonumberrecommendapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val  clearButton: Button by lazy {
        findViewById<Button>(R.id.clearButton)
    }
    private val  addButton: Button by lazy {
        findViewById<Button>(R.id.addButton)
    }   
    private val  runButton: Button by lazy {
        findViewById<Button>(R.id.runButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}