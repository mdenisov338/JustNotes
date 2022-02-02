package com.mdenisov338.justnotesapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        loadData()


        val fab: View = findViewById(R.id.fab)

        val fab2: View = findViewById(R.id.fab2)


        fab.setOnClickListener {
            val intent = Intent(this, Editor::class.java)
            startActivity(intent)
            }

        fab2.setOnClickListener {
            saveData()

        }


    }

    private fun saveData(){
        val thisnote = findViewById<EditText>(R.id.thisnote)


        val note: String = thisnote.text.toString()
        thisnote.text = Editable.Factory.getInstance().newEditable(note)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply(){
            putString("STRING_KEY", note)

        }.apply()

        Toast.makeText(this,"Сохранено!", Toast.LENGTH_LONG).show()

    }

    private fun loadData(){
        val thisnote = findViewById<EditText>(R.id.thisnote)
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        if(sharedPreferences.contains("STRING_KEY")) {
            val savedString = sharedPreferences.getString("STRING_KEY", null)

            thisnote.text = Editable.Factory.getInstance().newEditable(savedString)
        } else {

        }
    }



    override fun onBackPressed(){
        saveData()
        finish()
    }
}
