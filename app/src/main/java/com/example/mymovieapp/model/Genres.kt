package com.example.mymovieapp.model.genres

import com.example.mymovieapp.model.genres.Genre

data class Genres(
    val genres: List<Genre>
)

data class Genre(
    val id: Int,
    val name: String
)