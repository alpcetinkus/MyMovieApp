package com.example.mymovieapp.activitys

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mymovieapp.R
import com.example.mymovieapp.adapter.FromTurkeyAdapter
import com.example.mymovieapp.model.DetailMovie
import com.example.mymovieapp.service.MovieApiInterfaces
import com.example.mymovieapp.service.MovieApiService
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.popular_movie_card.*
import kotlinx.android.synthetic.main.popular_movie_card.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieId = arguments?.getString("movieIdKey")
        movieId?.let { fetchDetail(it) }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    fun fetchDetail(movieId: String) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterfaces::class.java)
        apiService.getDetail(movieId).enqueue(object : Callback<DetailMovie> {
            override fun onResponse(call: Call<DetailMovie>, response: Response<DetailMovie>) {
                if (response.isSuccessful) {
                    Log.e("success", response.body()?.toString() ?: "Response body is null")

                    val res = response.body()

                    tv_detailOverview.text = res?.overview
                    tv_detailTitle.text = res?.title
                    tv_detailReleaseDate.text = res?.release

                    Glide.with(iv_detailPoster.context)
                        .load("https://image.tmdb.org/t/p/w400${res?.poster}")

                        .into(iv_detailPoster)

                    Glide.with(iv_detailBackground.context)
                        .load("https://image.tmdb.org/t/p/w400${res?.backdrop}")

                        .into(iv_detailBackground)

                } else {

                    Log.e("fail", response.message())
                }
            }

            override fun onFailure(call: Call<DetailMovie>, t: Throwable) {

                Log.e("fail", t.message.toString())
            }
        })
    }

}