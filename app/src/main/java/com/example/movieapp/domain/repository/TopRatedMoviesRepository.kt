package com.example.movieapp.domain.repository

import com.example.movieapp.data.model.MoviesDTO


interface TopRatedMoviesRepository {
    suspend fun getTopRatedMovie(apiKey:String):MoviesDTO
}