package com.example.movieapp.data.repository

import com.example.movieapp.data.model.MoviesDTO
import com.example.movieapp.data.remote.MovieSearchApi
import com.example.movieapp.domain.repository.TopRatedMoviesRepository

class TopRatedMoviesRepositoryImpl(private val movieSearchApi: MovieSearchApi):TopRatedMoviesRepository {
    override suspend fun getTopRatedMovie(apiKey: String): MoviesDTO {
        return movieSearchApi.getTopRatedMovie(apiKey)
    }
}