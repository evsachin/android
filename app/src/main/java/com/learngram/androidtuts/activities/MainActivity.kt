package com.learngram.androidtuts.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.learngram.androidtuts.R
import com.learngram.androidtuts.showToast

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialization of views
        val etUserMessage: EditText = findViewById(R.id.etUserMessage)
        val btnShowToast : Button = findViewById(R.id.btnShowToast)
        val btnShareToOtherApps : Button = findViewById(R.id.btnShareToOtherApps)
        val btnRecyclerViewDemo =  findViewById<Button>(R.id.btnRecyclerViewDemo)

        val btnSendMessageToNextActivity =  findViewById<Button>(R.id.btnSendMessageToNextActivity)
        btnShowToast.setOnClickListener {
            Log.i("Main Activity","Show btn was clicked")
            showToast("Button was clicked...")
        }

        btnSendMessageToNextActivity.setOnClickListener {
            val message = etUserMessage.text.toString()
//            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message",message)
            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener {

            val message = etUserMessage.text.toString()
            val intent = Intent()
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type = "text/plain"
            intent.action = Intent.ACTION_SEND

            startActivity(Intent.createChooser(intent,"Plee select app : "))
        }

        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}