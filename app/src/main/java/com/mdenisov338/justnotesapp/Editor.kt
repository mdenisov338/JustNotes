package com.mdenisov338.justnotesapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat


class Editor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }


    fun vk_a(view: View){
        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/fivehex"))
        startActivity(i)
    }

    fun tg_a(view: View){

        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/fivehex"))
                startActivity(i)
    }

    fun gh_a(view: View){

        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/mdenisov338/JustNotes"))
                startActivity(i)
    }

    fun site_a(view: View){

        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://5hex.carrd.co/"))
                startActivity(i)
    }

    fun ratestore(view: View){

        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.mdenisov338.justnotesapp"))
        startActivity(i)
    }

    fun easter(view: View){
        Toast.makeText(this, "5 hex is 0x5", Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed(){
        finish()
    }


}

