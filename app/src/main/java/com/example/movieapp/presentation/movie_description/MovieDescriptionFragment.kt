package com.example.movieapp.presentation.movie_description

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieDescriptionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDescriptionFragment : Fragment() {

    private var _movieDescriptionBinding:FragmentMovieDescriptionBinding?=null
    val movieDescriptionBinding:FragmentMovieDescriptionBinding
    get()= _movieDescriptionBinding!!

    private val args:MovieDescriptionFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       _movieDescriptionBinding=FragmentMovieDescriptionBinding.inflate(inflater,container,false)
        return _movieDescriptionBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        args.movieClicked?.let {
            movieDescriptionBinding.movie=it
        }

        movieDescriptionBinding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}