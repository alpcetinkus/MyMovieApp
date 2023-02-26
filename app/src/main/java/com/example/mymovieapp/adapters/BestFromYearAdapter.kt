package com.example.mymovieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mymovieapp.R
import com.example.mymovieapp.models.BestFromYearMovie
import kotlinx.android.synthetic.main.best_from_year_card.view.*
import kotlinx.android.synthetic.main.popular_movie_card.view.*


class BestFromYearAdapter (
    private val movies: List<BestFromYearMovie>
) : RecyclerView.Adapter<BestFromYearAdapter.MovieViewHolder>() {
    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val design =
            LayoutInflater.from(parent.context).inflate(R.layout.best_from_year_card, parent, false)
        return MovieViewHolder(design)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        if (movie.poster == null) {
            Glide.with(holder.itemView.context)
                .load("https://image.tmdb.org/t/p/w400/4a0X2GKDmhhp1U2FUKtKY6uNQHL.jpg")
                .apply(RequestOptions().override(500, 660))
                .into(holder.itemView.iv_best_from_year)
        } else {
            Glide.with(holder.itemView.context)
                .load("https://image.tmdb.org/t/p/w400${movie.poster}")
                .apply(RequestOptions().override(400, 560))
                .into(holder.itemView.iv_best_from_year)
        }
    }

}