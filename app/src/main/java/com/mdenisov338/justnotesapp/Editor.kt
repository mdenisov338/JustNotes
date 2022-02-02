package com.mdenisov338.justnotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import android.R
import android.net.Uri
import android.view.View

import android.widget.EditText
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.lang.StringBuilder


class Editor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.mdenisov338.justnotesapp.R.layout.activity_editor)
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    fun exisave(view: View) {
        finish()
    }

    fun vk_a(view: View){
        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/mdenisovapps"))
        startActivity(i)
    }

    fun tg_a(view: View){

        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/mdenisovapps"))
                startActivity(i)
    }

    fun gh_a(view: View){

        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/mdenisov338/JustNotes"))
                startActivity(i)
    }

    fun site_a(view: View){

        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://mdenisovapps.carrd.co/"))
                startActivity(i)
    }

}

