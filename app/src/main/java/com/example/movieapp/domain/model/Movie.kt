package com.example.movieapp.domain.model

data class Movie(
    val id: Int,
    val originalTitle: String,
    val posterPath: String,
    val voteAverage: Double
)
