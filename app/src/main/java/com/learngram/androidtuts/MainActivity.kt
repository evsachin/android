package com.learngram.androidtuts

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowToast : Button = findViewById(R.id.btnShowToast)
        btnShowToast.setOnClickListener {
            Log.i("Main Activity","Show btn was clicked")
            Toast.makeText(this,"Button was clicked !!",Toast.LENGTH_SHORT).show()
        }
    }
}