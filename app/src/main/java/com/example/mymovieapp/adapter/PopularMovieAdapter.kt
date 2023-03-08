package com.example.mymovieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovieapp.R
import com.example.mymovieapp.model.PopularMovie
import kotlinx.android.synthetic.main.movie_card.*
import kotlinx.android.synthetic.main.movie_card.view.*


class PopularMovieAdapter(
    private val movies: List<PopularMovie>
) : RecyclerView.Adapter<PopularMovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val design =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return MovieViewHolder(design)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val media = movies[position]

        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w400${media.poster}")
//            .apply(RequestOptions().override(500, 700))
            .into(holder.itemView.iv_movie)

        holder.itemView.cardView_movie.setOnClickListener {
            val bundle = bundleOf("movieIdKey" to media.id)
            Navigation.findNavController(it).navigate(R.id.goToDetail,bundle)
        }
    }
}

// PopularMovieAtapter sınıfı:
// RecyclerView.Adapter sınıfını genişleterek bir adaptör oluşturur.
// Bu adaptör, PopularMovie tipindeki bir liste alır
// ve her bir öğeyi göstermek için bir RecyclerView öğesi oluşturur.
//
//
// MovieViewHolder sınıfı:
// bir View öğesi içindeki öğeleri temsil eden RecyclerView.
// ViewHolder sınıfını genişletir. Bu sınıf, onCreateViewHolder yönteminde
// kullanılacak olan View öğelerini tanımlar.
//
//
// onCreateViewHolder yöntemi:
// MovieViewHolder sınıfını kullanarak her bir RecyclerView öğesi için bir görünüm oluşturur.
// Burada, LayoutInflater sınıfı kullanılarak bir görünüm oluşturulur ve döndürülür.
//
//
// getItemCount yöntemi:
// adaptörün gösterilecek öğe sayısını döndürür.
// Burada, movies listesinin boyutu döndürülür.
//
//
// onBindViewHolder yöntemi:
// her bir öğe için verileri görünüme bağlar.
// Burada, Glide kütüphanesi kullanılarak bir resim yüklenir ve görünüme bağlanır.
