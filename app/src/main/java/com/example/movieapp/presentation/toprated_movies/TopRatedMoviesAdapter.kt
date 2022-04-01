package com.example.movieapp.presentation.toprated_movies

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ListItemRecyclerViewBinding
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetails

class TopRatedMoviesAdapter(var context:Context,val mItemClickListener:TopRatedMoviesAdapterEvents): RecyclerView.Adapter<TopRatedMoviesAdapter.MyViewHolder>() {

    private var listOfMovies= emptyList<MovieDetails>()
     inner class MyViewHolder(val binding:ListItemRecyclerViewBinding): RecyclerView.ViewHolder(binding.root){
         fun bind(item:MovieDetails,position:Int){
             binding.cv.setOnClickListener {
                 mItemClickListener.onMovieClicked(item)
             }
         }
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMoviesAdapter.MyViewHolder {
        val binding=ListItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopRatedMoviesAdapter.MyViewHolder, position: Int) {
        val currentItem=listOfMovies[position]
       holder.binding.movie=currentItem
        holder.bind(currentItem,position)
    }

    override fun getItemCount(): Int {
      return listOfMovies.size
    }

    fun setMovieList(movieList:List<MovieDetails>){
        listOfMovies=movieList
        notifyDataSetChanged()
    }

    interface TopRatedMoviesAdapterEvents{
        fun onMovieClicked(movie:MovieDetails)
    }
}