package com.example.mymovieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovieapp.R
import com.example.mymovieapp.model.ResultGenreType
import kotlinx.android.synthetic.main.cast_card.view.*
import kotlinx.android.synthetic.main.movie_card.view.*

class GenreTypeAdapter(private var genreType: List<ResultGenreType> )
    : RecyclerView.Adapter<GenreTypeAdapter.CardGenreTypeDesign>() {


    class CardGenreTypeDesign(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardGenreTypeDesign {
        val design = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return CardGenreTypeDesign(design)
    }

    override fun onBindViewHolder(holder: CardGenreTypeDesign, position: Int) {
        val movie = genreType[position]

        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w400${movie.poster_path}")
            .into(holder.itemView.iv_movie)
    }

    override fun getItemCount(): Int {
        return genreType.size
    }
}