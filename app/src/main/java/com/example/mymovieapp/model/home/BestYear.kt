package com.example.mymovieapp.model.home

data class BestYear(
    val page: Int,
    val results: List<ResultBestYear>,
    val total_pages: Int,
    val total_results: Int
)

data class ResultBestYear(
//    val adult: Boolean,
//    val backdrop_path: String,
//    val genre_ids: List<Int>,
    val id: Int,
//    val original_language: String,
//    val original_title: String,
//    val overview: String,
//    val popularity: Double,
    var poster_path: String
//    val release_date: String,
//    val title: String,
//    val video: Boolean,
//    val vote_average: Int,
//    val vote_count: Int
)