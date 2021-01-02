package com.rajtilak.pal.themoviedb.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rajtilak.pal.themoviedb.domain.MoviePreview
import com.rajtilak.pal.themoviedb.ui.movie.UpcomingMoviesAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MoviePreview>?){
    val adapter = recyclerView.adapter as UpcomingMoviesAdapter
    adapter.submitList(data)
}