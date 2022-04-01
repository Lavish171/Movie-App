package com.example.movieapp.presentation.toprated_movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.movieapp.R
import com.example.movieapp.commons.Constants
import com.example.movieapp.databinding.FragmentTopRatedMoviesBinding
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetails
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class TopRatedMoviesFragment : Fragment() {

    private var _binding:FragmentTopRatedMoviesBinding?=null
    val binding:FragmentTopRatedMoviesBinding
        get()= _binding!!

    private val topratedMoviesAdapter : TopRatedMoviesAdapter by lazy {
        TopRatedMoviesAdapter(requireContext(),object:TopRatedMoviesAdapter.TopRatedMoviesAdapterEvents{
            override fun onMovieClicked(movie: MovieDetails) {
                findNavController()
                    .navigate(TopRatedMoviesFragmentDirections.actionTopRatedMoviesFragmentToMovieDescriptionFragment(movieClicked = movie))
            }
        })
    }

    private val topRatedMoviesViewModel:TopRatedMoviesViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding= FragmentTopRatedMoviesBinding.inflate(inflater,container,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        topRatedMoviesViewModel.searchTopRatedMoviesList(Constants.API_KEY)
        binding.rvTopratedmovies.adapter=topratedMoviesAdapter

        lifecycle.coroutineScope.launchWhenCreated {
            topRatedMoviesViewModel.movieSearchList.collect {
                if(it.isLoading){
                    binding.progressBar.visibility=View.VISIBLE
                }
                if(it.error.isNotBlank()){
                    binding.progressBar.visibility=View.GONE
                }
                it.data?.let {
                    binding.progressBar.visibility=View.GONE
                    //now set the list into the adapter and notify the adapter
                    topratedMoviesAdapter.setMovieList(it)
                }

            }
        }
    }
}