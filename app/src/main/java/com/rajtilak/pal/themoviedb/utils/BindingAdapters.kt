package com.rajtilak.pal.themoviedb.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rajtilak.pal.themoviedb.domain.MoviePreview
import com.rajtilak.pal.themoviedb.network.TMDBApi
import com.rajtilak.pal.themoviedb.ui.movie.MoviesAdapter



@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        val newUrl = TMDBApi.IMAGE_BASE_URL+imgUrl
        val imgUri = newUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
//            .apply(
//                RequestOptions()
//                .placeholder(R.drawable.loading_animation)
//                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("titleText")
fun bindTitleText(textView: TextView, titleText: String?){
    titleText?.let{

//        textView.text = titleText.smartTruncate(20)
        textView.text = titleText
    }
}

@BindingAdapter("rating")
fun bindingRating(textView: TextView, rating: Float?){
    rating?.let{
        if (rating==0F){
            textView.text = "Rating Unavailable"
        }
        else{
            textView.text = "Rating: ${rating} / 10.0"
        }
    }
}
@BindingAdapter("release")
fun bindingRelease(textView: TextView, release: String?){
    release?.let {
        textView.text = "Release: "+release
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MoviePreview>?){
    val adapter = recyclerView.adapter as MoviesAdapter
    adapter.submitList(data)
}