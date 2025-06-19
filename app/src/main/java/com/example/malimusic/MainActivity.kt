package com.example.malimusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var songTitleEditText: EditText
    private lateinit var artistNameEditText: EditText
    private lateinit var ratingEditText: EditText
    private lateinit var commentEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songTitleEditText = findViewById(R.id.textInput)
        artistNameEditText = findViewById(R.id.textInput2)
        ratingEditText = findViewById(R.id.textInput3)
        commentEditText = findViewById(R.id.textInput4)

        val submitButton = findViewById<Button>(R.id.btnAdd2Playlist)
        submitButton.setOnClickListener {
            var valid = true

            if (songTitleEditText.text.isNullOrBlank()) {
                songTitleEditText.error = "Please enter title of song."
                valid = false
            }
            if (artistNameEditText.text.isNullOrBlank()) {
                artistNameEditText.error = "Enter the name of an artist"
                valid = false
            }
            if (ratingEditText.text.isNullOrBlank()) {
                ratingEditText.error = "Give the song a rating."
                valid = false
            }
            if (commentEditText.text.isNullOrBlank()) {
                commentEditText.error = "Please enter a comment."
                valid = false
            }

            if (valid) {
                // Replace TargetActivity::class.java with your actual target
                val intent = Intent(this, MainActivity::class.java)
                // Optionally, put extras here
                startActivity(intent)
            }
        }
    }
}