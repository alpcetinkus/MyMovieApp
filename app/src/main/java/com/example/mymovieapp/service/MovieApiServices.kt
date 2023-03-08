package com.example.mymovieapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApiService {

    companion object{
        private const val BASE_URL = "https://api.themoviedb.org"
        private var retrofit : Retrofit? = null

        fun getInstance() : Retrofit{
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}


// Bu kod,
// Retrofit kütüphanesi ile bir API servisine bağlanmak için kullanılan bir fonksiyon içerir.
//
// Bu fonksiyon, API isteklerinin yapıldığı Retrofit nesnesini oluşturur ve döndürür.
//
// getInstance fonksiyonu, öncelikle bir sabit olan BASE_URL ile birlikte
// Retrofit nesnesinin oluşturulması için gerekli ayarları içeren bir Retrofit.Builder örneği oluşturur.
// Bu örnekte GsonConverterFactory sınıfı kullanılarak JSON verileri Gson kütüphanesiyle dönüştürülür.
//
// Sonra, Retrofit nesnesi, builder yardımıyla oluşturulur ve sınıf seviyesinde bir nullable değişkende saklanır.
// getInstance fonksiyonu, retrofit değişkeninin null olup olmadığını kontrol eder.
// Eğer null ise, retrofit değişkeni, builder tarafından oluşturulan Retrofit nesnesi ile tanımlanır ve döndürülür.
// Eğer retrofit değişkeni null değilse, zaten bir Retrofit nesnesi oluşturulmuştur ve bu nesne döndürülür.
//
// Bu şekilde, getInstance fonksiyonu, uygulama boyunca tek bir Retrofit nesnesinin oluşturulmasını ve paylaşılmasını sağlar.
// Bu sayede, API istekleri sırasında tekrar tekrar Retrofit nesnesi oluşturmaya gerek kalmaz.