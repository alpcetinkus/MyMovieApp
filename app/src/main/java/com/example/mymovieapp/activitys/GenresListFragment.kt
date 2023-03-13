package com.example.mymovieapp.activitys

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mymovieapp.R
import com.example.mymovieapp.adapter.GenreClickInterface
import com.example.mymovieapp.adapter.GenresListAdapter
import com.example.mymovieapp.model.GenroToMovie
import com.example.mymovieapp.model.detail.MovieDetail
import com.example.mymovieapp.model.genres.Genre
import com.example.mymovieapp.model.genres.Genres
import com.example.mymovieapp.service.MovieApiService
import kotlinx.android.synthetic.main.fragment_genres_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GenresListFragment : Fragment(), GenreClickInterface {

    var genresList: MutableList<Genre> = mutableListOf()
    lateinit var genresListAdapter: GenresListAdapter
    lateinit var rvGenresList: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_genres_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvGenresList = view.findViewById(R.id.rv_genres_list)
        rv_genres_list.setHasFixedSize(true)
        rv_genres_list.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        genresListAdapter = GenresListAdapter(genresList, this)
        rv_genres_list.adapter = genresListAdapter

        fetchMarketList()
    }

    fun fetchMarketList() {
        MovieApiService.getApiImplementation().getGenreList().enqueue(object :
            Callback<Genres> {
            override fun onResponse(call: Call<Genres>?, response: Response<Genres>?) {
                if (response != null) {
                    var responseBody = response.body()
                    for (genre in responseBody!!.genres) {
                        genresList.add(Genre(genre.id, genre.name))
                    }
                    genresListAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<Genres>?, t: Throwable?) {
                Log.e("alppppp", "Failed::" + (t))
            }
        })
    }

    override fun onGenreClick(id: String) {
        MovieApiService.getApiImplementation().getGenreToMovie(id).enqueue(object : Callback<GenroToMovie> {
            override fun onResponse(call: Call<GenroToMovie>?, response: Response<GenroToMovie>?) {
                Log.e("alppppppppp", "$id secildi")


            }

            override fun onFailure(call: Call<GenroToMovie>?, t: Throwable?) {
                Log.e("alppppp", "Failed::" + (t))
            }
        })
    }

}


