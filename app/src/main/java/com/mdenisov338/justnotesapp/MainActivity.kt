package com.mdenisov338.justnotesapp

import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.WindowCompat
import com.google.android.material.color.DynamicColors


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
        val textView = findViewById<TextView>(R.id.textView)
        val myCustomFont : Typeface? = ResourcesCompat.getFont(this, R.font.monty)
        textView.typeface = myCustomFont

        val counter = findViewById<TextView>(R.id.counter)
        val thisnote = findViewById<EditText>(R.id.thisnote)
        val time = findViewById<TextView>(R.id.counter2)


        thisnote.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?,
                                           p1: Int, p2: Int, p3: Int) {
                counter.text = "Счетчик символов: ${p0?.toString()?.length}"
                val exptime = p1/536
                time.text = "Время чтения: ~${exptime} мин."

            }

            override fun onTextChanged(p0: CharSequence?,
                                       p1: Int, p2: Int, p3: Int) {
                // count number of inputted characters in edit text
                counter.text = "Счетчик символов: ${p0?.toString()?.length}"
                val exptime = p1/536
                time.text = "Время чтения: ~${exptime} мин."
            }

            override fun afterTextChanged(p0: Editable?) {
                counter.text = "Счетчик символов: ${p0?.toString()?.length}"
            }
        })

    }

    private fun saveData(){
        val thisnote = findViewById<EditText>(R.id.thisnote)
        val counter =findViewById<TextView>(R.id.counter)
        val time = findViewById<TextView>(R.id.counter2)


        val note: String = thisnote.text.toString()
        val count: String = counter.text.toString()
        val exptim: String = time.text.toString()
        thisnote.text = Editable.Factory.getInstance().newEditable(note)
        time.text = exptim

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply(){
            putString("STRING_KEY", note)
            putString("STRING_NUM", count)
            putString("STRING_TIME", exptim)
        }.apply()

        Toast.makeText(this,"Сохранено!", Toast.LENGTH_LONG).show()

    }

    private fun loadData(){
        val thisnote = findViewById<EditText>(R.id.thisnote)
        val counter =findViewById<TextView>(R.id.counter)
        val time = findViewById<TextView>(R.id.counter2)
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        if(sharedPreferences.contains("STRING_KEY")) {
            val savedString = sharedPreferences.getString("STRING_KEY", null)
            val savedNum = sharedPreferences.getString("STRING_NUM", null)
            val savedTime = sharedPreferences.getString("STRING_TIME", null)

            thisnote.text = Editable.Factory.getInstance().newEditable(savedString)
            counter.text = savedNum
            time.text = savedTime
        } else {

        }
    }



    override fun onBackPressed(){
        saveData()
        finish()
    }


}

