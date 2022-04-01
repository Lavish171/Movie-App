package com.example.movieapp.data.model


import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetails
import com.google.gson.annotations.SerializedName

data class MovieDTO(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Int>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("video")
    val video: Boolean?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?
)

fun MovieDTO.toDomainMovie():Movie{
    return Movie(
        id=this.id?:0,
        originalTitle=this.title?:"",
        posterPath=this.posterPath?:"",
        voteAverage=this.voteAverage?:0.0)
}

fun MovieDTO.toDomainMovieDetails():MovieDetails{
    return MovieDetails(
        id=this.id?:0,
        originalLanguage=this.originalLanguage?:"",
        originalTitle=this.originalTitle?:"",
        overview=this.overview?:"",
        releaseDate=this.releaseDate?:"",
        voteAverage=this.voteAverage?:0.0,
        posterPath=this.posterPath?:""
    )
}