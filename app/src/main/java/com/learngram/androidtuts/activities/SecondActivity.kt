package com.learngram.androidtuts.activities

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.learngram.androidtuts.R
import com.learngram.androidtuts.showToast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val txvUserMessage = findViewById<TextView>(R.id.txvUserMessage)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            val msg = bundle.getString("user_message")
            showToast(msg)
            txvUserMessage.text = msg
        }

    }
}