package com.example.movieapp.presentation.toprated_movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.commons.Resource
import com.example.movieapp.domain.usecase.GetTopRatedMoviesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TopRatedMoviesViewModel @Inject constructor(private val getTopRatedMoviesListUseCase: GetTopRatedMoviesListUseCase)
    :ViewModel()
{
        private var _movieSearchList=MutableStateFlow<MovieSearchState>(MovieSearchState())
        val movieSearchList :StateFlow<MovieSearchState> = _movieSearchList

        fun searchTopRatedMoviesList(s:String){
            getTopRatedMoviesListUseCase(s).onEach {
                when(it){
                    is Resource.Error->{
                        _movieSearchList.value= MovieSearchState(error = it.message?:" Error")
                    }
                    is Resource.Loading->{
                        _movieSearchList.value= MovieSearchState(isLoading = true)
                    }
                    is Resource.Success->{
                        _movieSearchList.value=MovieSearchState(data=it.data)
                    }

                }
            }.launchIn(viewModelScope)
        }

}