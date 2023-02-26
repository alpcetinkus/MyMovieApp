package com.example.mymovieapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PopularMovie(

    @SerializedName("id")
    val id: String?,


    @SerializedName("poster_path")
    val poster: String?,


) : Parcelable {
    constructor() : this("", "")
}



// Bu kod,
// trendde olan filmler ve diziler  için gerekli olan özellikleri içeren bir model sınıfı tanımlar.

// @Parcelize: bu sınıfın Parcelable arayüzünü uyguladığını belirtir.
// Bu, sınıfın Android tarafından kolayca serileştirilebilir hale getirilmesine olanak sağlar.
//
//@SerializedName: JSON nesnesindeki anahtarların hangi sınıf özelliklerine karşılık geldiğini belirtir.
// id, poster TMDB API'den trend dizi ve filmler için alınan JSON nesnelerindeki anahtarlarla eşleştirilir.
// Her özellik, sırasıyla bir film id'si, film afişi URL'si gibi bilgiler içerir.
//
//constructor() metodu, tüm özelliklerin varsayılan değerleriyle birlikte oluşturulabileceği bir boş kurucu metodudur.
