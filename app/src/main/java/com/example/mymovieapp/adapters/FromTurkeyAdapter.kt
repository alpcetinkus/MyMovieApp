package com.example.mymovieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mymovieapp.R
import com.example.mymovieapp.models.FromTurkey
import kotlinx.android.synthetic.main.from_turkey_card.view.*


class FromTurkeyAdapter (
    private val movies: List<FromTurkey>
) : RecyclerView.Adapter<FromTurkeyAdapter.MovieViewHolder>() {
    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val design =
            LayoutInflater.from(parent.context).inflate(R.layout.from_turkey_card, parent, false)
        return MovieViewHolder(design)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w400${movie.poster}")
            .apply(RequestOptions().override(400, 560))
            .into(holder.itemView.iv_from_turkey)
    }

}