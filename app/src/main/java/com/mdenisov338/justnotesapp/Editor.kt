package com.mdenisov338.justnotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import android.graphics.Typeface
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.color.DynamicColors


class Editor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.mdenisov338.justnotesapp.R.layout.activity_editor)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val textView = findViewById<TextView>(com.mdenisov338.justnotesapp.R.id.textView)
        val myCustomFont : Typeface? = ResourcesCompat.getFont(this, com.mdenisov338.justnotesapp.R.font.monty)
        textView.typeface = myCustomFont

        val textView2 = findViewById<TextView>(com.mdenisov338.justnotesapp.R.id.textView2)
        val textView3 = findViewById<TextView>(com.mdenisov338.justnotesapp.R.id.textView3)
        val textView4 = findViewById<TextView>(com.mdenisov338.justnotesapp.R.id.textView4)
        val textView5 = findViewById<TextView>(com.mdenisov338.justnotesapp.R.id.textView5)
        textView2.typeface = myCustomFont
        textView3.typeface = myCustomFont
        textView4.typeface = myCustomFont
        textView5.typeface = myCustomFont

        val btn = findViewById<Button>(com.mdenisov338.justnotesapp.R.id.button4)
        val btn2 = findViewById<Button>(com.mdenisov338.justnotesapp.R.id.button6)
        val btn3 = findViewById<Button>(com.mdenisov338.justnotesapp.R.id.button7)
        val btn4 = findViewById<Button>(com.mdenisov338.justnotesapp.R.id.button8)
        val btn5 = findViewById<Button>(com.mdenisov338.justnotesapp.R.id.button9)
        btn.typeface = myCustomFont
        btn2.typeface = myCustomFont
        btn3.typeface = myCustomFont
        btn4.typeface = myCustomFont
        btn5.typeface = myCustomFont
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

