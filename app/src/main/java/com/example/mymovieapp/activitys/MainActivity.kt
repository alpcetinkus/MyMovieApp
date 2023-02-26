package com.example.mymovieapp.activitys


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mymovieapp.R
import com.example.mymovieapp.adapters.PopularMovieAdapter
import com.example.mymovieapp.adapters.BestFromYearAdapter
import com.example.mymovieapp.adapters.FromTurkeyAdapter
import com.example.mymovieapp.adapters.UpComingAdapter
import com.example.mymovieapp.models.*
import com.example.mymovieapp.services.MovieApiInterfaces
import com.example.mymovieapp.services.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rc_trending.setHasFixedSize(true)
        rc_trending.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        rc_person_popular.setHasFixedSize(true)
        rc_person_popular.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        rc_upcoming.setHasFixedSize(true)
        rc_upcoming.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        rc_bestfromturkey.setHasFixedSize(true)
        rc_bestfromturkey.layoutManager =
            StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        fetchPopularMovie { movies ->
            rc_trending.adapter = PopularMovieAdapter(movies)
        }

        fetchBestFromYearMovie { movies ->
            rc_person_popular.adapter = BestFromYearAdapter(movies)
        }

        fetchUpComingMovie { movies ->
            rc_upcoming.adapter = UpComingAdapter(movies)
        }

        fetchFromTurkey { movies ->
            rc_bestfromturkey.adapter = FromTurkeyAdapter(movies)
        }

    }

    fun fetchPopularMovie(callback: (List<PopularMovie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterfaces::class.java)
        apiService.getPopularList().enqueue(object : Callback<PopularMovieResponse> {
            override fun onResponse(
                call: Call<PopularMovieResponse>,
                response: Response<PopularMovieResponse>
            ) {
                return callback(response.body()!!.PopularMovie)
                Log.e("success", response.body()!!.PopularMovie.toString())
            }

            override fun onFailure(call: Call<PopularMovieResponse>, t: Throwable) {
                Log.e("fail", t.message.toString())

            }


        })
    }

    fun fetchBestFromYearMovie(callback: (List<BestFromYearMovie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterfaces::class.java)
        apiService.getBestFromYearList().enqueue(object : Callback<BestFromYearResponse> {
            override fun onResponse(
                call: Call<BestFromYearResponse>,
                response: Response<BestFromYearResponse>
            ) {
                return callback(response.body()!!.bestFromYearMovie)
                Log.e("success", response.body()!!.bestFromYearMovie.toString())
            }

            override fun onFailure(call: Call<BestFromYearResponse>, t: Throwable) {
                Log.e("fail", t.message.toString())

            }

        })
    }


    fun fetchUpComingMovie(callback: (List<UpComingMovie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterfaces::class.java)
        apiService.getUpComingMovieList().enqueue(object : Callback<UpComingResponse> {
            override fun onResponse(
                call: Call<UpComingResponse>,
                response: Response<UpComingResponse>
            ) {
                return callback(response.body()!!.UpComingMovies)
                Log.e("success", response.body()!!.UpComingMovies.toString())
            }

            override fun onFailure(call: Call<UpComingResponse>, t: Throwable) {
                Log.e("fail", t.message.toString())

            }

        })
    }

    fun fetchFromTurkey(callback: (List<FromTurkey>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterfaces::class.java)
        apiService.getPopularFromTurkeyList().enqueue(object : Callback<FromTurkeyResponse> {
            override fun onResponse(
                call: Call<FromTurkeyResponse>,
                response: Response<FromTurkeyResponse>
            ) {
                return callback(response.body()!!.fromTurkeyMovie)
                Log.e("success", response.body()!!.fromTurkeyMovie.toString())
            }

            override fun onFailure(call: Call<FromTurkeyResponse>, t: Throwable) {
                Log.e("fail", t.message.toString())

            }

        })
    }


}


// fetchPopularMovie fonksiyonu, popüler film verilerini API'den almak için kullanılır.
// Bu fonksiyon, MovieApiService sınıfından bir örnek alır ve ardından getPopularMovieList fonksiyonunu çağırarak popüler film verilerini alır.
// Bu işlem, bir Callback nesnesi kullanılarak gerçekleştirilir.






