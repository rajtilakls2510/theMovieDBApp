package com.rajtilak.pal.themoviedb.ui.movie

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rajtilak.pal.themoviedb.databinding.MovieListItemBinding
import com.rajtilak.pal.themoviedb.domain.MoviePreview

private const val TAG = "UpcomingMoviesAdapter"
class UpcomingMoviesAdapter: ListAdapter<MoviePreview, UpcomingMoviesAdapter.MoviePreviewViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePreviewViewHolder {
       return MoviePreviewViewHolder(MovieListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MoviePreviewViewHolder, position: Int) {
        val moviePreview = getItem(position)
        holder.bind(moviePreview)
    }



    class MoviePreviewViewHolder(private var binding: MovieListItemBinding) :RecyclerView.ViewHolder(binding.root){

        fun bind(moviePreview: MoviePreview){
            binding.movie = moviePreview
            Log.d(TAG, "bind: Binding preview"+ moviePreview)
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MoviePreview>(){
        override fun areItemsTheSame(oldItem: MoviePreview, newItem: MoviePreview): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MoviePreview, newItem: MoviePreview): Boolean {
            return oldItem.id == newItem.id
        }
    }

}