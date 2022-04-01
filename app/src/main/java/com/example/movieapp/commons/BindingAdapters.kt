package com.example.movieapp.commons

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.R

@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, s: String?) {
   // val options = RequestOptions.placeholderOf(R.drawable.loading).error(R.drawable.error)
    val url="https://image.tmdb.org/t/p/w500$s"
    Glide.with(view).load(url ?: "").into(view)
}

@BindingAdapter("my_name")
fun myname(view:TextView,s:String?){
    view.text="Rating $s"
}

@BindingAdapter("language")
fun movieLanguage(view:TextView,s:String?){
    view.text="Language $s"
}

@BindingAdapter("releaseDate")
fun releaseDate(view:TextView,s:String?){
    view.text="Release Date $s"
}

