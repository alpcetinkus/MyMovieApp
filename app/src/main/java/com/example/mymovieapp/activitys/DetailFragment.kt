package com.example.mymovieapp.activitys

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.example.mymovieapp.R
import com.example.mymovieapp.adapter.CastAdapter
import com.example.mymovieapp.adapter.SimilarAdapter
import com.example.mymovieapp.model.*
import com.example.mymovieapp.model.detail.*
import com.example.mymovieapp.service.MovieApiService
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment() {
    var castList: MutableList<CastX> = mutableListOf()
    lateinit var castAdapter: CastAdapter
    lateinit var rvCast: RecyclerView
    //
    var similarMovieList: MutableList<ResultSimilarMovie> = mutableListOf()
    lateinit var similarMovieAdapter: SimilarAdapter
    lateinit var rvSimilarMovieList: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvCast = view.findViewById(R.id.rv_detailCast)
        rv_detailCast.setHasFixedSize(true)
        rv_detailCast.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        castAdapter = CastAdapter(castList)
        rv_detailCast.adapter = castAdapter
        //
        rvSimilarMovieList = view.findViewById(R.id.rv_detailSimilar)
        rv_detailSimilar.setHasFixedSize(true)
        rv_detailSimilar.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        similarMovieAdapter = SimilarAdapter(similarMovieList)
        rv_detailSimilar.adapter = similarMovieAdapter

        val movieId = arguments?.getInt("movieIdKey")
        fetchDetail(movieId.toString())
        fetchCastList(movieId.toString())
        fetchSimilarMovie(movieId.toString())

    }

    fun fetchDetail(movieId: String){
        movieId.let {
            MovieApiService.getApiImplementation().getDetail(it)
                .enqueue(object : Callback<MovieDetail> {
                    override fun onResponse(
                        call: Call<MovieDetail>,
                        response: Response<MovieDetail>
                    ) {

                        Log.e("alppppppppp", "$id secildi")

                        val resBody = response.body()
                        tv_detailOverview.text = resBody?.overview
                        tv_detailTitle.text = resBody?.title
                        tv_detailReleaseDate.text = resBody?.release_date

                        Glide.with(iv_detailPoster.context)
                            .load("https://image.tmdb.org/t/p/w400${resBody?.poster_path}")

                            .into(iv_detailPoster)

                        Glide.with(iv_detailBackground.context)
                            .load("https://image.tmdb.org/t/p/w400${resBody?.backdrop_path}")

                            .into(iv_detailBackground)
                    }

                    override fun onFailure(call: Call<MovieDetail>, t: Throwable) {

                        Log.e("alppppp", "Failed::" + (t))
                    }
                })
        }

    }

    fun fetchCastList(movieId: String){
        movieId.let {
            MovieApiService.getApiImplementation().getCastList(it)
                .enqueue(object : Callback<Cast> {
                    override fun onResponse(
                        call: Call<Cast>,
                        response: Response<Cast>
                    ) {

                        Log.e("alppppppppp", "$id secildi")

                        if (response.isSuccessful) {
                            val resBody = response.body()
                            castList.addAll(resBody?.cast!!)
                            castAdapter.notifyDataSetChanged()
                        }


                    }

                    override fun onFailure(call: Call<Cast>, t: Throwable) {

                        Log.e("alppppp", "Failed::" + (t))
                    }
                })
        }

    }

    fun fetchSimilarMovie(movieId: String){
        movieId.let {
            MovieApiService.getApiImplementation().getSimilarMovieList(it)
                .enqueue(object : Callback<SimilarMovie> {
                    override fun onResponse(
                        call: Call<SimilarMovie>,
                        response: Response<SimilarMovie>
                    ) {

                        Log.e("alppppppppp", "$id secildi")

                        if (response.isSuccessful) {
                            val resBody = response.body()
                            similarMovieList.addAll(resBody?.results!!)
                            similarMovieAdapter.notifyDataSetChanged()
                        }


                    }

                    override fun onFailure(call: Call<SimilarMovie>, t: Throwable) {

                        Log.e("alppppp", "Failed::" + (t))
                    }
                })
        }

    }


}


