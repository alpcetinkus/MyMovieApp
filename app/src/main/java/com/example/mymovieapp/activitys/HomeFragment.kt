package com.example.mymovieapp.activitys

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mymovieapp.R
import com.example.mymovieapp.adapter.*
import com.example.mymovieapp.model.*
import com.example.mymovieapp.model.detail.MovieDetail
import com.example.mymovieapp.model.home.*
import com.example.mymovieapp.service.MovieApiService
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(), DetailClickInterface {

    var popularMovies: MutableList<ResultPopular> = mutableListOf()
    lateinit var popularMovieAdapter: PopularMovieAdapter
    lateinit var popularMovieRecyclerView: RecyclerView
    //
    var bestYears: MutableList<ResultBestYear> = mutableListOf()
    lateinit var bestYearAdapter: BestYearAdapter
    lateinit var bestYearRecyclerView: RecyclerView
    //
    var upcomingMovies: MutableList<UpComingResult> = mutableListOf()
    lateinit var upcomingAdapter: UpComingAdapter
    lateinit var upcomingRecyclerView: RecyclerView
    //
    var popularMoviesInTurkey: MutableList<PopularMovieInTurkeyResult> = mutableListOf()
    lateinit var popularMoviesInTurkeyAdapter: PopularMovieInTurkeyAdapter
    lateinit var popularMoviesInTurkeyRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerViews()
        fetchMovieLists()
    }

    fun fetchMovieLists() {
        MovieApiService.getApiImplementation().getPopularList().enqueue(object :
            Callback<PopularMovie> {
            override fun onResponse(call: Call<PopularMovie>?, response: Response<PopularMovie>?) {
                if (response != null) {
                    var responseBody = response.body()
                    for (movie in responseBody!!.results) {
                        popularMovies.add(ResultPopular(movie.id, movie.poster_path))
                    }
                    popularMovieAdapter.notifyDataSetChanged()

                }
            }

            override fun onFailure(call: Call<PopularMovie>?, t: Throwable?) {
                Log.e("alppppp", "Failed::" + (t))
            }
        })

        MovieApiService.getApiImplementation().getBestFromYearList().enqueue(object :
            Callback<BestYear> {
            override fun onResponse(call: Call<BestYear>?, response: Response<BestYear>?) {

                val responseBody = response?.body()
                for (movie in responseBody!!.results) {
                    if (movie.poster_path == null){
                        movie.poster_path = "/yBT2H97fFlzDAiT0SUwaH7B0qQI.jpg"
                    } else {
                        movie.poster_path = movie.poster_path
                    }
                    bestYears.add(ResultBestYear(movie.id, movie.poster_path))
                }
                bestYearAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<BestYear>?, t: Throwable?) {
                Log.e("alppppp", "Failed::" + (t))
            }
        })

        MovieApiService.getApiImplementation().getPopularFromTurkeyList().enqueue(object :
            Callback<PopularMovieInTurkey> {
            override fun onResponse(
                call: Call<PopularMovieInTurkey>?,
                response: Response<PopularMovieInTurkey>?
            ) {
                if (response != null) {
                    var responseBody = response.body()
                    for (movie in responseBody!!.results) {
                        popularMoviesInTurkey.add(
                            PopularMovieInTurkeyResult(
                                movie.id,
                                movie.poster_path
                            )
                        )
                    }
                    popularMoviesInTurkeyAdapter.notifyDataSetChanged()

                }
            }

            override fun onFailure(call: Call<PopularMovieInTurkey>?, t: Throwable?) {
                Log.e("alppppp", "Failed::" + (t))
            }
        })

        MovieApiService.getApiImplementation().getUpComingMovieList().enqueue(object :
            Callback<UpComingMovie> {
            override fun onResponse(
                call: Call<UpComingMovie>?,
                response: Response<UpComingMovie>?
            ) {
                if (response != null) {
                    var responseBody = response.body()
                    for (movie in responseBody!!.results) {
                        upcomingMovies.add(UpComingResult(movie.id, movie.poster_path))
                    }
                    upcomingAdapter.notifyDataSetChanged()

                }
            }

            override fun onFailure(call: Call<UpComingMovie>?, t: Throwable?) {
                Log.e("alppppp", "Failed::" + (t))
            }
        })
    }

    fun setupRecyclerViews() {

        popularMovieRecyclerView = view?.findViewById(R.id.rc_popular) ?: return
        rc_popular.setHasFixedSize(true)
        rc_popular.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        popularMovieAdapter = PopularMovieAdapter(popularMovies, this)
        rc_popular.adapter = popularMovieAdapter
        //
        bestYearRecyclerView = view?.findViewById(R.id.rc_best_year) ?: return
        rc_best_year.setHasFixedSize(true)
        rc_best_year.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        bestYearAdapter = BestYearAdapter(bestYears)
        rc_best_year.adapter = bestYearAdapter
        //
        upcomingRecyclerView = view?.findViewById(R.id.rc_upcoming) ?: return
        rc_upcoming.setHasFixedSize(true)
        rc_upcoming.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        upcomingAdapter = UpComingAdapter(upcomingMovies)
        rc_upcoming.adapter = upcomingAdapter
        //
        popularMoviesInTurkeyRecyclerView = view?.findViewById(R.id.rc_bestfromturkey) ?: return
        rc_bestfromturkey.setHasFixedSize(true)
        rc_bestfromturkey.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        popularMoviesInTurkeyAdapter = PopularMovieInTurkeyAdapter(popularMoviesInTurkey)
        rc_bestfromturkey.adapter = popularMoviesInTurkeyAdapter
    }
    override fun onDetailClick(id: String) {
        MovieApiService.getApiImplementation().getDetail(id)
            .enqueue(object : Callback<MovieDetail> {
                override fun onResponse(
                    call: Call<MovieDetail>?,
                    response: Response<MovieDetail>?
                ) {
                    Log.e("alppppppppp", "$id secildi")


                }

                override fun onFailure(call: Call<MovieDetail>?, t: Throwable?) {
                    Log.e("alppppp", "Failed::" + (t))
                }
            })
    }
}

//HomeFragment s??n??f??d??r. HomeFragment, RecyclerView'leri kullanarak farkl?? film listelerini g??steren bir Fragment't??r.
//S??n??f d??rt film listesi i??erir: pop??ler filmler, en iyi y??llar, yakla??an filmler ve T??rkiye'deki pop??ler filmler.
//S??n??f ayr??ca her biri i??in bir adapter i??erir: pop??ler film adapt??r??, en iyi y??l adapt??r??, yakla??an adapt??r ve
//T??rkiye'deki pop??ler filmler adapt??r??. Bu adapt??rler, RecyclerView'leri film ????eleriyle doldurmak i??in kullan??l??r.
//fetchMovieLists () i??levi, MovieApiService kullanarak her bir film listesi i??in verileri getirmek ve
//ilgili adapt??r??n verilerini g??ncellemekle sorumludur.
//setupRecyclerViews () i??levi, her bir RecyclerView ve bunlar??n ilgili verileriyle kar????la??t??r??labilir adapt??rleri ba??lat??r.
//Bu s??n??f ayr??ca DetailClickInterface'i uygular, bu da RecyclerView'lerdeki film ????elerine t??klamalar?? i??lemek i??in kullan??l??r.
