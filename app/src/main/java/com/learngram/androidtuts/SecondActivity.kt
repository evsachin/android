package com.learngram.androidtuts

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val txvUserMessage = findViewById<TextView>(R.id.txvUserMessage)

        val bundle : Bundle? = intent.extras
        val msg = bundle!!.getString("user_message")

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()

        txvUserMessage.text = msg
    }
}