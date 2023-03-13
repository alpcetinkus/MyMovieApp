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
import kotlinx.android.synthetic.main.genres_list_card.view.*
import kotlinx.android.synthetic.main.movie_card.*
import kotlinx.android.synthetic.main.movie_card.view.*


class PopularMovieAdapter(private var movies: List<ResultPopular>,val clickListener: DetailClickInterface )
    : RecyclerView.Adapter<PopularMovieAdapter.CardPopularListDesign>() {


    class CardPopularListDesign(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardPopularListDesign {
        val design = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return CardPopularListDesign(design)
    }

    override fun onBindViewHolder(holder: CardPopularListDesign, position: Int) {
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
interface DetailClickInterface {
    fun onDetailClick(id: String)
}

//Bu bir PopularMovieAdapter sınıfıdır. Bu sınıf,
//ResultPopular tipinde bir film listesini RecyclerView ile eşleştirir ve her film öğesini görüntülemek için özel bir görünüm tasarımını kullanır.
//
//Sınıf, clickListener parametresi aracılığıyla tıklama olaylarını dinleyen bir DetailClickInterface arayüzünü uygular.
//
//CardPopularListDesign iç sınıfı, her film öğesi için kullanılan özel görünüm tasarımını temsil eder.
//onCreateViewHolder() fonksiyonu, her film öğesi için bir görünüm tasarımı oluşturur.
//onBindViewHolder() fonksiyonu, her film öğesi için oluşturulan görünüm tasarımına verileri bağlar ve tıklama olaylarını yönetir.
//getItemCount() fonksiyonu, listedeki film sayısını döndürür.
//
//DetailClickInterface arayüzü, bir film öğesine tıklandığında gerçekleştirilecek eylemi tanımlayan onDetailClick() fonksiyonunu içerir.

