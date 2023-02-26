package com.example.mymovieapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FromTurkey(

    @SerializedName("id")
    val id: String?,


    @SerializedName("poster_path")
    val poster: String?,


) : Parcelable {
    constructor() : this("", "")
}
