package com.example.mymovieapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UpComingResponse(
    @SerializedName("results")
    val UpComingMovies : List<UpComingMovie>

): Parcelable {
    constructor() : this(mutableListOf())
}
