package com.example.androidmodulespractice.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmodulespractice.R
import com.example.androidmodulespractice.recyclerview.model.MovieModel
import org.w3c.dom.Text

class MovieAdapter(
    private val movieModel: List<MovieModel>,
    private val listener: OnAdapterListener
) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : MovieAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val movie = movieModel[position]
        holder.movieCover.setImageResource(movie.poster)
        holder.movieTitle.text = movie.title
        holder.itemView.setOnClickListener {
            listener.onClick(movie)
        }
    }

    override fun getItemCount(): Int {
        return movieModel.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val movieCover: ImageView = view.findViewById(R.id.ivMovieCover)
        val movieTitle: TextView = view.findViewById(R.id.tvMovieTitle)
    }

    interface OnAdapterListener {
        fun onClick(location: MovieModel)
    }
}