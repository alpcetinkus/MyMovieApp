package com.example.mymovieapp.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApiService {
    companion object {
        val BASE_URL = "https://api.themoviedb.org"
        fun getApiImplementation(): MovieApiInterfaces {
            return getClient(BASE_URL).create(MovieApiInterfaces::class.java)
        }
        fun getClient(baseUrl: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        fun getOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
                )
                .build()
        }
    }
}

//Bu, bir MovieApiService sınıfıdır ve birkaç fonksiyon içerir.
//Companion object, sınıfın üyesi olmayan bir nesne oluşturmanın bir yoludur ve BASE_URL adlı sabit bir özelliği içerir.
//Bu özellik, tüm API çağrıları için kullanılacak olan ana URL'yi temsil eder.
//
//getApiImplementation(), Retrofit örneği alır ve MovieApiInterfaces arabirimine dönüştürür.
//Bu, MovieApiInterfaces arabirimini uygulayan bir nesne döndürür ve API çağrılarını yapmak için kullanılabilir.
//
//getClient(), Retrofit nesnesi oluşturur ve BASE_URL ve GsonConverterFactory kullanarak yapılandırır.
//
//getOkHttpClient(), HTTP isteklerini yürütmek için bir OkHttpClient örneği döndürür.
//Bu örneğe, HTTP isteklerini loglamak için HttpLoggingInterceptor eklendi.
//Bu, geliştirme sırasında hata ayıklama yapmak için kullanılabilir.