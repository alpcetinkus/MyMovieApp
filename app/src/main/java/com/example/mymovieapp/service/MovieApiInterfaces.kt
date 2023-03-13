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

//Bu, bir sunucudan film verilerini almak için API çağrıları yapmak için kullanılan
//@GET anotasyonu ile işaretlenmiş çeşitli işlevler bildiren bir arayüz olan MovieApiInterfaces adlı bir arayüzdür.
//
//Fonksiyonlar arasında popüler filmlerin bir listesini almak için getPopularList() yer alır.
//getBestFromYearList() belirli bir yıldan en iyi derecelendirilmiş filmleri alır.
//getUpComingMovieList() gelecek filmlerin bir listesini alır.
//getPopularFromTurkeyList() Türkiye'de popüler filmlerin bir listesini alır.
//getDetail() belirli bir film hakkında ayrıntılı bilgileri alır.
//getGenreList() film türlerinin bir listesini alır.
//getCastList() belirli bir film için oyuncu kadrosunun bir listesini alır.
//getSimilarMovieList() belirli bir filme benzer filmlerin bir listesini alır.
//getGenreToMovie() belirli bir türe dayalı olarak filmlerin bir listesini alır.
//
//Her işlev, sunucudan veri almanın asenkron işlemini temsil eden bir Call nesnesi döndürür.
//Sunucudan gelen yanıt, PopularMovie, BestYear, UpComingMovie, PopularMovieInTurkey, MovieDetail, Genres, Cast, SimilarMovie veya GenroToMovie
//gibi ilgili veri sınıfının bir nesnesi olarak döndürülür.