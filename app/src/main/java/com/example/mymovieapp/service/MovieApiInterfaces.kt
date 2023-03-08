package com.example.mymovieapp.service

import com.example.mymovieapp.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiInterfaces {
    @GET("/3/movie/popular?api_key=d0db8f3e22e7317943ec9cd6fad83b1d")
    fun getPopularList(): Call<PopularMovieResponse>

    @GET("/3/discover/movie?api_key=d0db8f3e22e7317943ec9cd6fad83b1d&primary_release_year=2022&sort_by=vote_average.desc")
    fun getBestFromYearList(): Call<BestFromYearResponse>

    @GET("/3/movie/upcoming?api_key=d0db8f3e22e7317943ec9cd6fad83b1d&language=en-US")
    fun getUpComingMovieList(): Call<UpComingResponse>

    @GET("/3/discover/movie?api_key=d0db8f3e22e7317943ec9cd6fad83b1d&certification_country=TR&certification=R&sort_by=vote_average.desc")
    fun getPopularFromTurkeyList(): Call<FromTurkeyResponse>

    @GET("/3/movie/{id}?api_key=d0db8f3e22e7317943ec9cd6fad83b1d&language=en-US")
    fun getDetail(@Path("id")id: String): Call<DetailMovie>

}

// Bu kod,
// bir API servisine HTTP isteklerinde bulunmak için kullanılan örnek metotları tanımlar.
//
// Bu interface'de, bir GET isteği kullanılarak popüler filmleri almak için getPopularMovieList adlı bir metot tanımlanmıştır.
//
// getPopularMovieList metodu, Call sınıfından parametre olarak PopularResponse sınıfını döndürür.
// Bu PopularResponse sınıfı, JSON verileri Gson kütüphanesiyle dönüştürülebilir hale getirir ve API'den dönen verileri
// Java nesnelerine dönüştürmek için kullanılır.
//
// Bu interface, Retrofit kütüphanesiyle kullanılarak, tanımlanan metotlarla API servisine istek göndermek için kullanılır.