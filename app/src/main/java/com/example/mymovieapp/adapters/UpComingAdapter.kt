package com.example.mymovieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mymovieapp.R

import com.example.mymovieapp.models.UpComingMovie

import kotlinx.android.synthetic.main.up_coming_card.view.*

class UpComingAdapter (
    private val movies: List<UpComingMovie>
) : RecyclerView.Adapter<UpComingAdapter.MovieViewHolder>() {
    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val design =
            LayoutInflater.from(parent.context).inflate(R.layout.up_coming_card, parent, false)
        return UpComingAdapter.MovieViewHolder(design)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w400${movie.poster}")
            .apply(RequestOptions().override(400, 560))
            .into(holder.itemView.iv_upcoming)
    }

}