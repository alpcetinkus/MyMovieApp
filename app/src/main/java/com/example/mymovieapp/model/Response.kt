package com.example.mymovieapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BestFromYearResponse(
    @SerializedName("results")
    val bestFromYearMovie : List<BestFromYearMovie>

): Parcelable {
    constructor() : this(mutableListOf())
}

@Parcelize
data class FromTurkeyResponse(
    @SerializedName("results")
    val fromTurkeyMovie : List<FromTurkey>

): Parcelable {
    constructor() : this(mutableListOf())
}

@Parcelize
data class UpComingResponse(
    @SerializedName("results")
    val UpComingMovies : List<UpComingMovie>

): Parcelable {
    constructor() : this(mutableListOf())
}

@Parcelize
data class PopularMovieResponse(
    @SerializedName("results")
    val PopularMovie : List<PopularMovie>

): Parcelable {
    constructor() : this(mutableListOf())
}

@Parcelize
data class DetailsResponse(
    @SerializedName("")
    val detailMovie : List<DetailMovie>

): Parcelable {
    constructor() : this(mutableListOf())
}









// Bu kod, TrendResponse adlı bir veri sınıfı içerir.
// Bu sınıf, bir API'den dönen popüler film verilerini temsil etmek için kullanılır.
//
// @Parcelize:
// Kotlin Android Extensions kütüphanesi tarafından sağlanan bir özelliktir.
// Bu özellik, sınıfın Parcelable arayüzünü otomatik olarak uygular.
// Bu sayede, sınıf örneği bir Android bileşenleri arasında geçirilirken veriler otomatik olarak seri hale getirilir ve geri dönüştürülür.
//
// TrendResponse sınıfı, movies adında bir özellik içerir.
// Bu özellik, bir List<TrendMedia> nesnesini temsil eder.
//
// @SerializedName: Gson kütüphanesi tarafından kullanılır ve JSON verilerini,
// Kotlin sınıflarındaki özelliklerle eşleştirmek için kullanılır.
//
//TrendResponse sınıfının ikinci bir yapıcısı da vardır.
// Bu yapıcı, sınıf örneği oluşturulurken kullanılan varsayılan değerleri sağlamak için kullanılır.
// Bu durumda, yapıcı, movies özelliğini boş bir listeye atar.
//
