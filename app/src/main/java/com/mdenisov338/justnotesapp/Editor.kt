package com.mdenisov338.justnotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import android.R
import android.view.View

import android.widget.EditText
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.lang.StringBuilder


class Editor : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        WindowCompat.setDecorFitsSystemWindows(window, false)


    }

    fun exisave(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

