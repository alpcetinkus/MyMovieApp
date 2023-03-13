package com.example.mymovieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovieapp.R
import com.example.mymovieapp.model.home.ResultBestYear
import kotlinx.android.synthetic.main.movie_card.view.*


class BestYearAdapter(private var movies: List<ResultBestYear> )
    : RecyclerView.Adapter<BestYearAdapter.CardBestYearListDesign>() {


    class CardBestYearListDesign(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBestYearListDesign {
        val design = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return CardBestYearListDesign(design)
    }

    override fun onBindViewHolder(holder: CardBestYearListDesign, position: Int) {
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