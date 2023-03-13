package com.example.mymovieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieapp.R
import com.example.mymovieapp.model.genres.Genre
import kotlinx.android.synthetic.main.genres_list_card.view.*
import kotlinx.android.synthetic.main.movie_card.view.*


class GenresListAdapter(private var genreslist: List<Genre>,val clickListener: GenreClickInterface )
    : RecyclerView.Adapter<GenresListAdapter.CardGenreListDesign>() {


    class CardGenreListDesign(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardGenreListDesign {
        val design = LayoutInflater.from(parent.context).inflate(R.layout.genres_list_card, parent, false)
        return CardGenreListDesign(design)
    }

    override fun onBindViewHolder(holder: CardGenreListDesign, position: Int) {
        val genre = genreslist[position]

        holder.itemView.tv_genres_list.text = genre.name

        holder.itemView.genres_cardView.setOnClickListener {
            val bundle = bundleOf("genreIdKey" to genre.id)
            Navigation.findNavController(it).navigate(R.id.goToGenreToMovie,bundle)
        }

    }

    override fun getItemCount(): Int {
        return genreslist.size
    }

}
interface GenreClickInterface {
    fun onGenreClick(id: String)
}