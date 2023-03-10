package com.example.mymovieapp.service

import com.example.mymovieapp.model.*
import com.example.mymovieapp.model.detail.Cast
import com.example.mymovieapp.model.detail.MovieDetail
import com.example.mymovieapp.model.detail.SimilarMovie
import com.example.mymovieapp.model.genres.Genres
import com.example.mymovieapp.model.home.BestYear
import com.example.mymovieapp.model.home.PopularMovie
import com.example.mymovieapp.model.home.PopularMovieInTurkey
import com.example.mymovieapp.model.home.UpComingMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiInterfaces {
    @GET("/3/movie/popular?api_key=d0db8f3e22e7317943ec9cd6fad83b1d")
    fun getPopularList(): Call<PopularMovie>

    @GET("/3/discover/movie?api_key=d0db8f3e22e7317943ec9cd6fad83b1d&primary_release_year=2022&sort_by=vote_average.desc")
    fun getBestFromYearList(): Call<BestYear>

    @GET("/3/movie/upcoming?api_key=d0db8f3e22e7317943ec9cd6fad83b1d&language=en-US")
    fun getUpComingMovieList(): Call<UpComingMovie>

    @GET("/3/discover/movie?api_key=d0db8f3e22e7317943ec9cd6fad83b1d&certification_country=TR&certification=R&sort_by=vote_average.desc")
    fun getPopularFromTurkeyList(): Call<PopularMovieInTurkey>

    @GET("/3/movie/{id}?api_key=d0db8f3e22e7317943ec9cd6fad83b1d&language=en-US")
    fun getDetail(@Path("id")id: String): Call<MovieDetail>

    @GET("/3/genre/movie/list?api_key=d0db8f3e22e7317943ec9cd6fad83b1d")
    fun getGenreList(): Call<Genres>

    @GET("/3/movie/{id}/credits?api_key=d0db8f3e22e7317943ec9cd6fad83b1d")
    fun getCastList(@Path("id")id: String): Call<Cast>

    @GET("/3/movie/{id}/similar?api_key=d0db8f3e22e7317943ec9cd6fad83b1d")
    fun getSimilarMovieList(@Path("id")id: String): Call<SimilarMovie>

    @GET("/3/discover/movie")
    fun getGenreToMovie(@Query("with_genres") id: String,
                        @Query("api_key") apiKey: String = "d0db8f3e22e7317943ec9cd6fad83b1d",
                        @Query("sort_by") sortBy: String = "vote_average.desc",
                        @Query("vote_count.gte") voteCount: Int = 10): Call<GenroToMovie>
}

//Bu, bir sunucudan film verilerini almak i??in API ??a??r??lar?? yapmak i??in kullan??lan
//@GET anotasyonu ile i??aretlenmi?? ??e??itli i??levler bildiren bir aray??z olan MovieApiInterfaces adl?? bir aray??zd??r.
//
//Fonksiyonlar aras??nda pop??ler filmlerin bir listesini almak i??in getPopularList() yer al??r.
//getBestFromYearList() belirli bir y??ldan en iyi derecelendirilmi?? filmleri al??r.
//getUpComingMovieList() gelecek filmlerin bir listesini al??r.
//getPopularFromTurkeyList() T??rkiye'de pop??ler filmlerin bir listesini al??r.
//getDetail() belirli bir film hakk??nda ayr??nt??l?? bilgileri al??r.
//getGenreList() film t??rlerinin bir listesini al??r.
//getCastList() belirli bir film i??in oyuncu kadrosunun bir listesini al??r.
//getSimilarMovieList() belirli bir filme benzer filmlerin bir listesini al??r.
//getGenreToMovie() belirli bir t??re dayal?? olarak filmlerin bir listesini al??r.
//
//Her i??lev, sunucudan veri alman??n asenkron i??lemini temsil eden bir Call nesnesi d??nd??r??r.
//Sunucudan gelen yan??t, PopularMovie, BestYear, UpComingMovie, PopularMovieInTurkey, MovieDetail, Genres, Cast, SimilarMovie veya GenroToMovie
//gibi ilgili veri s??n??f??n??n bir nesnesi olarak d??nd??r??l??r.