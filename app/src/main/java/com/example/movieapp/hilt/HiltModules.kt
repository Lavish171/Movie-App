package com.example.movieapp.hilt

import com.example.movieapp.commons.Constants
import com.example.movieapp.data.remote.MovieSearchApi
import com.example.movieapp.data.repository.TopRatedMoviesRepositoryImpl
import com.example.movieapp.domain.repository.TopRatedMoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HiltModules {

    @Provides
    @Singleton
    fun provideMovieSearchApi():MovieSearchApi{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(MovieSearchApi::class.java)
    }

    @Provides
    fun providesTopRatedMoviesRepository(movieSearchApi: MovieSearchApi):TopRatedMoviesRepository{
        return TopRatedMoviesRepositoryImpl(movieSearchApi)
    }


}