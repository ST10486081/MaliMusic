package com.example.malimusic

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewScreen : AppCompatActivity() {

    private val songList= listOf(
        Song("BETTER NOW", "A-Reece", 5),
        Song("Water", "Tyla", 4.0),
        Song("Uthando", "Kelvin Momo", 3.0),
        Song("No Child Left Behind", "Khanye", 5.0)
        // Add more songs as needed
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_screen)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewSongs)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SongAdapter(songList)

        val btnAverageRating = findViewById<Button>(R.id.button2)
        val tvAverageRating = findViewById<TextView>(R.id.button3)

        btnAverageRating.setOnClickListener {
            // Calculate average using a loop
            var total = 0.0
            for (song in songList) {
                total += song.rating
            }
            val avg = if (songList.isNotEmpty()) total / songList.size else 0.0
            tvAverageRating.text = "Average Rating: %.2f".format(avg)
        }
    }
}