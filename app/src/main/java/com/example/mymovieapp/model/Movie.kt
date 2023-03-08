package com.example.mymovieapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BestFromYearMovie(

    @SerializedName("id")
    val id: String?,


    @SerializedName("poster_path")
    val poster: String?,


) : Parcelable {
    constructor() : this("", "")
}

@Parcelize
data class PopularMovie(

    @SerializedName("id")
    val id: String?,


    @SerializedName("poster_path")
    val poster: String?,


    ) : Parcelable {
    constructor() : this("", "")
}

@Parcelize
data class FromTurkey(

    @SerializedName("id")
    val id: String?,


    @SerializedName("poster_path")
    val poster: String?,


    ) : Parcelable {
    constructor() : this("", "")
}

@Parcelize
data class UpComingMovie(

    @SerializedName("id")
    val id: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("poster_path")
    val poster: String?,

    @SerializedName("release_date")
    val release: String?

) : Parcelable {
    constructor() : this("", "", "", "")
}

@Parcelize
data class DetailMovie(

    @SerializedName("id")
    val id: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("poster_path")
    val poster: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("release_date")
    val release: String?,

    @SerializedName("backdrop_path")
    val backdrop: String?

) : Parcelable {
    constructor() : this("", "", "", "", "", "")
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

