package com.mdenisov338.justnotesapp


import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setSupportActionBar(findViewById(R.id.toolbar))
        try {
            supportActionBar!!.setDisplayShowTitleEnabled(false)
        } catch (e: NullPointerException) {
        }


        loadData()





       /* val textView = findViewById<TextView>(R.id.textView)
        val myCustomFont : Typeface? = ResourcesCompat.getFont(this, R.font.monty)
        textView.typeface = myCustomFont

        var oldScrollYPostion = 0

        val counter = findViewById<TextView>(R.id.counter)
        val thisnote = findViewById<EditText>(R.id.thisnote)
        val scrollView = findViewById<ScrollView>(R.id.scrollview)

        scrollView.viewTreeObserver.addOnScrollChangedListener(OnScrollChangedListener {
            if (scrollView.scrollY > oldScrollYPostion) {
                fab.visibility = View.GONE
                fab2.visibility = View.GONE
            } else if (scrollView.scrollY < oldScrollYPostion || scrollView.scrollY <= 0) {
                fab.visibility = View.VISIBLE
                fab2.visibility = View.VISIBLE
            }
            oldScrollYPostion = scrollView.scrollY
        })

        val count1: String = getString(R.string.count1)


        thisnote.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?,
                                           p1: Int, p2: Int, p3: Int) {
                counter.text = "${count1}: ${p0?.toString()?.length}"

            }

            override fun onTextChanged(p0: CharSequence?,
                                       p1: Int, p2: Int, p3: Int) {
                // count number of inputted characters in edit text
                counter.text = "${count1}: ${p0?.toString()?.length}"
            }

            override fun afterTextChanged(p0: Editable?) {
                counter.text = "${count1}: ${p0?.toString()?.length}"
            }
        })*/


    }



    private fun saveData(){
        val thisnote = findViewById<EditText>(R.id.thisnote)
        //val counter =findViewById<TextView>(R.id.counter)


        val note: String = thisnote.text.toString()
        //val count: String = counter.text.toString()
        thisnote.text = Editable.Factory.getInstance().newEditable(note)


        //saving text to shared prefs

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("STRING_KEY", note)
            //putString("STRING_NUM", count)
        }.apply()

        Toast.makeText(this,"Сохранено!", Toast.LENGTH_LONG).show()

        //widget update
        val ids = AppWidgetManager.getInstance(application).getAppWidgetIds(
            ComponentName(
                application,
                NoteWidget::class.java
            )
        )
        val myWidget = NoteWidget()
        myWidget.onUpdate(this, AppWidgetManager.getInstance(this), ids)
    }

    fun loadData(){
        val thisnote = findViewById<EditText>(R.id.thisnote)
        //val counter =findViewById<TextView>(R.id.counter)
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        if(sharedPreferences.contains("STRING_KEY")) {
            val savedString = sharedPreferences.getString("STRING_KEY", null)
            val savedNum = sharedPreferences.getString("STRING_NUM", null)

            thisnote.text = Editable.Factory.getInstance().newEditable(savedString)
            //counter.text = savedNum
        } else {

        }
    }



    override fun onBackPressed(){
        saveData()
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.mymenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.first -> {
                val thisnote = findViewById<EditText>(R.id.thisnote)
                val text = ""
                thisnote.text = Editable.Factory.getInstance().newEditable(text)
                true
            }
            R.id.second -> {
                val thisnote = findViewById<EditText>(R.id.thisnote)
                val string: String = getString(R.string.counters)
                var count = thisnote.getText().length
                var time = count/512

                val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)

                builder.setTitle("$string")
                builder.setMessage("$count | ≈$time")

                builder.setPositiveButton("OK") { dialog, which ->
                }

                builder.show()
                true
            }
            R.id.third -> {
                val intent = Intent(this, Editor::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }




}

