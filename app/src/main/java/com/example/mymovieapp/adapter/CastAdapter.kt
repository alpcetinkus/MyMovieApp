package com.example.mymovieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovieapp.R
import com.example.mymovieapp.model.detail.CastX
import kotlinx.android.synthetic.main.cast_card.view.*

class CastAdapter(private var cast: List<CastX> )
    : RecyclerView.Adapter<CastAdapter.CardCastListDesign>() {


    class CardCastListDesign(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardCastListDesign {
        val design = LayoutInflater.from(parent.context).inflate(R.layout.cast_card, parent, false)
        return CardCastListDesign(design)
    }

    override fun onBindViewHolder(holder: CardCastListDesign, position: Int) {
        val movie = cast[position]

        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w400${movie.profile_path}")
            .into(holder.itemView.iv_cast_poster)
        holder.itemView.tv_character_name.text = movie.character
        holder.itemView.tv_orginal_name.text = movie.name


    }

    override fun getItemCount(): Int {
        return cast.size
    }
}