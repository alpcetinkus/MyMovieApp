package com.example.mymovieapp.models

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
