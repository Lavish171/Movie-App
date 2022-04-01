package com.example.movieapp.domain.usecase

import com.example.movieapp.commons.Resource
import com.example.movieapp.data.model.toDomainMovie
import com.example.movieapp.data.model.toDomainMovieDetails
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetails
import com.example.movieapp.domain.repository.TopRatedMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject


class GetTopRatedMoviesListUseCase  @Inject constructor (private val topRatedMoviesRepository: TopRatedMoviesRepository) {


   operator fun invoke(apiKey:String): Flow<Resource<List<MovieDetails>>> = flow {
       try{
           emit(Resource.Loading())
           val response=topRatedMoviesRepository.getTopRatedMovie(apiKey)
           val list=if(response.results.isNullOrEmpty()) emptyList<MovieDetails>() else response.results.map {
               it.toDomainMovieDetails()
           }

           emit(Resource.Success(data=list))

       }
       catch (e:HttpException){
           emit(Resource.Error(message = e.localizedMessage?:"Unknown Error"))
       }
       catch (e:IOException){
           emit(Resource.Error(message = e.localizedMessage?:"Unknown Error"))
       }
       catch (e:Exception){
           emit(Resource.Error(message = e.localizedMessage?:"Unknown Error"))
       }
   }
}

//remote-> repository -> repository impl -> use case ->view model -> fragment/activity