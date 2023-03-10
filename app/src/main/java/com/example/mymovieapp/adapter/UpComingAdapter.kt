package com.example.mymovieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovieapp.R

import com.example.mymovieapp.model.home.ResultPopular
import com.example.mymovieapp.model.home.UpComingResult
import kotlinx.android.synthetic.main.movie_card.view.*


class UpComingAdapter(private var movies: List<UpComingResult> )
    : RecyclerView.Adapter<UpComingAdapter.CardUpComingListDesign>() {


    class CardUpComingListDesign(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardUpComingListDesign {
        val design = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return CardUpComingListDesign(design)
    }

    override fun onBindViewHolder(holder: CardUpComingListDesign, position: Int) {
        val movie = movies[position]

        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w400${movie.poster_path}")
            .into(holder.itemView.iv_movie)

        holder.itemView.cardView_movie.setOnClickListener {
            val bundle = bundleOf("movieIdKey" to movie.id)
            Navigation.findNavController(it).navigate(R.id.goToDetail,bundle)
        }

    }

    override fun getItemCount(): Int {
        return movies.size
    }


}