package com.rajtilak.pal.themoviedb.domain

data class MoviePreview(
    val id: Int,
    val title: String,
    val poster_path: String,
    val rating: Float,
    val release_date: String
) {


}