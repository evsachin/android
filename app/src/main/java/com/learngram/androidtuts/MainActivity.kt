package com.learngram.androidtuts

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialization of views
        val btnShowToast : Button = findViewById(R.id.btnShowToast)
        val etUserMessage: EditText = findViewById(R.id.etUserMessage)



       val btnSendMessageToNextActivity =  findViewById<Button>(R.id.btnSendMessageToNextActivity)
        btnShowToast.setOnClickListener {
            Log.i("Main Activity","Show btn was clicked")
            Toast.makeText(this,"Button was clicked !!",Toast.LENGTH_SHORT).show()
        }

        btnSendMessageToNextActivity.setOnClickListener {
            val message = etUserMessage.text.toString()
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}