package com.mdenisov338.justnotesapp


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.*

class AddEditNoteActivity : AppCompatActivity() {

    lateinit var noteTitleEdt: EditText
    lateinit var noteEdt: EditText
    lateinit var saveBtn: Button

    lateinit var viewModal: NoteViewModal
    var noteID = -1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setSupportActionBar(findViewById(R.id.toolbar))
        try {
            supportActionBar!!.setDisplayShowTitleEnabled(false)
        } catch (e: NullPointerException) {
        }

        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModal::class.java)

        noteTitleEdt = findViewById(R.id.idEdtNoteName)
        noteEdt = findViewById(R.id.idEdtNoteDesc)

        val noteType = intent.getStringExtra("noteType")
        if (noteType.equals("Edit")) {
            // on below line we are setting data to edit text.
            val noteTitle = intent.getStringExtra("noteTitle")
            val noteDescription = intent.getStringExtra("noteDescription")
            noteID = intent.getIntExtra("noteId", -1)
            noteTitleEdt.setText(noteTitle)
            noteEdt.setText(noteDescription)
        } else {
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.mymenu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.first -> {
                val thisnote = findViewById<EditText>(R.id.idEdtNoteDesc)
                val text = ""
                thisnote.text = Editable.Factory.getInstance().newEditable(text)
                true
            }
            R.id.second -> {
                val thisnote = findViewById<EditText>(R.id.idEdtNoteDesc)
                val string: String = getString(R.string.counters)
                val count = thisnote.text.length
                val time = count / 512



                MaterialAlertDialogBuilder(this)
                    .setTitle("$string")
                    .setMessage("$count | ≈$time")
                    .setPositiveButton("OK") { dialog, which ->
                    }
                    .show()

                true
            }
            R.id.third -> {
                val noteType = intent.getStringExtra("noteType")

                val noteTitle = noteTitleEdt.text.toString()
                val noteDescription = noteEdt.text.toString()
                if (noteType.equals("Edit")) {
                    if (noteTitle.isNotEmpty()) {
                        val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                        val currentDateAndTime: String = sdf.format(Date())
                        val updatedNote = Note(noteTitle, noteDescription, currentDateAndTime)
                        updatedNote.id = noteID
                        viewModal.updateNote(updatedNote)
                        Toast.makeText(this, R.string.saved, Toast.LENGTH_LONG).show()
                    }
                } else {
                    if (noteTitle.isNotEmpty()) {
                        val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                        val currentDateAndTime: String = sdf.format(Date())
                        viewModal.addNote(Note(noteTitle, noteDescription, currentDateAndTime))
                        Toast.makeText(this, R.string.saved, Toast.LENGTH_LONG).show()
                    }
                }
                this.finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        val noteType = intent.getStringExtra("noteType")

        val noteTitle = noteTitleEdt.text.toString()
        val noteDescription = noteEdt.text.toString()
        if (noteType.equals("Edit")) {
            if (noteTitle.isNotEmpty()) {
                val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                val currentDateAndTime: String = sdf.format(Date())
                val updatedNote = Note(noteTitle, noteDescription, currentDateAndTime)
                updatedNote.id = noteID
                viewModal.updateNote(updatedNote)
                Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show()
            }
        } else {
            if (noteTitle.isNotEmpty()) {
                val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                val currentDateAndTime: String = sdf.format(Date())
                viewModal.addNote(Note(noteTitle, noteDescription, currentDateAndTime))
                Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show()
            }
        }
        this.finish()
    }
}
