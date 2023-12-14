package com.example.androidmodulespractice.recyclerview

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmodulespractice.R
import com.example.androidmodulespractice.databinding.ActivityRecyclerViewMainBinding
import com.example.androidmodulespractice.recyclerview.adapter.MovieAdapter
import com.example.androidmodulespractice.recyclerview.model.MovieModel

class RecyclerViewMain : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        topBar()
        movieModelAdapter()
    }

    private fun topBar() {
        binding.topBar.topBarApp.setTitle("Movie App")
    }

    private fun movieModelAdapter() {
        val movies = listOf(
            MovieModel("The Avengers", R.drawable.the_avengers),
            MovieModel("Avengers: Age of Ultron", R.drawable.avengers_age_of_ultron),
            MovieModel("Avengers: Infinity War", R.drawable.avengers_infinity_war),
            MovieModel("Avengers: Endgame", R.drawable.avengers_endgame),
            MovieModel("The Mandalorian", R.drawable.the_mandalorian),
        )

        val moviesAdapter =
            MovieAdapter(movies, object : MovieAdapter.OnAdapterListener {
                override fun onClick(movie: MovieModel) {
                    Log.e("RecyclerViewP1", movie.title)
                    Toast.makeText(applicationContext, movie.title, Toast.LENGTH_SHORT).show()
                }
            })
        findViewById<RecyclerView>(R.id.rvMain).adapter = moviesAdapter
    }
}