package com.example.mymovieapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FromTurkeyResponse(
    @SerializedName("results")
    val fromTurkeyMovie : List<FromTurkey>

): Parcelable {
    constructor() : this(mutableListOf())
}
