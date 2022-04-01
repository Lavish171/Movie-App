package com.example.movieapp.data.remote

import com.example.movieapp.data.model.MoviesDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieSearchApi {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(@Query("api_key")apiKey:String):MoviesDTO


    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey: String):MoviesDTO


}