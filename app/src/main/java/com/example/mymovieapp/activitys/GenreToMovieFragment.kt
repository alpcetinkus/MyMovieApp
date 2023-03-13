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
import com.example.mymovieapp.adapter.GenreTypeAdapter
import com.example.mymovieapp.model.GenroToMovie
import com.example.mymovieapp.model.ResultGenreType
import com.example.mymovieapp.service.MovieApiService
import kotlinx.android.synthetic.main.fragment_genre_to_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GenreToMovieFragment : Fragment() {
    var genresType: MutableList<ResultGenreType> = mutableListOf()
    lateinit var genreTypeAdapter: GenreTypeAdapter
    lateinit var rvGenresList: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_genre_to_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvGenresList = view.findViewById(R.id.rv_genres_type)
        rv_genres_type.setHasFixedSize(true)
        rv_genres_type.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        genreTypeAdapter = GenreTypeAdapter(genresType)
        rv_genres_type.adapter = genreTypeAdapter

        val genreId = arguments?.getInt("genreIdKey")
        fetchGenreToMovie(genreId.toString())
    }

    fun fetchGenreToMovie(genreId: String) {
        genreId.let {
            MovieApiService.getApiImplementation().getGenreToMovie(it)
                .enqueue(object : Callback<GenroToMovie> {
                    override fun onResponse(
                        call: Call<GenroToMovie>,
                        response: Response<GenroToMovie>
                    ) {

                        Log.e("alppppppppp", "$id secildi")

                        if (response.isSuccessful) {
                            val resBody = response.body()
                            genresType.addAll(resBody?.results!!)
                            genreTypeAdapter.notifyDataSetChanged()
                        }


                    }

                    override fun onFailure(call: Call<GenroToMovie>, t: Throwable) {

                        Log.e("alppppp", "Failed::" + (t))
                    }
                })
        }
    }
}