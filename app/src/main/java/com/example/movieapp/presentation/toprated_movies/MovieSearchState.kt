package com.example.movieapp.presentation.toprated_movies

import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetails

data class MovieSearchState(
    val data:List<MovieDetails>?=null,
    val error:String="",
    val isLoading:Boolean=false
)
