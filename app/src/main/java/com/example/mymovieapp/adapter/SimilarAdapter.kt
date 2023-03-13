package com.example.mymovieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovieapp.R
import com.example.mymovieapp.model.detail.ResultSimilarMovie
import kotlinx.android.synthetic.main.movie_card.view.*

class SimilarAdapter(private var similar: List<ResultSimilarMovie> )
    : RecyclerView.Adapter<SimilarAdapter.CardSimilarMovieDesign>() {


    class CardSimilarMovieDesign(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardSimilarMovieDesign {
        val design = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return CardSimilarMovieDesign(design)
    }

    override fun onBindViewHolder(holder: CardSimilarMovieDesign, position: Int) {
        val movie = similar[position]

        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w400${movie.poster_path}")
            .into(holder.itemView.iv_movie)

// cardview click fonksiyonu yapilacak

    }

    override fun getItemCount(): Int {
        return similar.size
    }
}