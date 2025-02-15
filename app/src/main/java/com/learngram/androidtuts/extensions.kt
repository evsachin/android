package com.learngram.androidtuts

import android.app.Activity
import android.content.Context
import android.widget.Toast
import kotlin.time.Duration

fun Context.showToast(message:String?, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message,duration).show()
}