package com.rajtilak.pal.themoviedb.network

import com.rajtilak.pal.themoviedb.database.DatabaseTopRatedMovie
import com.rajtilak.pal.themoviedb.database.DatabaseUpcomingMovie
import com.squareup.moshi.Json

data class NetworkUpcomingMoviesContainer(val results: List<NetworkUpcomingMovie>)
data class NetworkTopRatedMoviesContainer(val results: List<NetworkTopRatedMovie>)


data class NetworkUpcomingMovie(
    val id: Int,
    val title: String,
    val poster_path: String,
    @Json(name ="vote_average")
    val rating: Float,
    val release_date: String
)

fun NetworkUpcomingMoviesContainer.asDatabaseModel(): List<DatabaseUpcomingMovie>{
    return results.map {
        DatabaseUpcomingMovie(
            id = it.id,
            title = it.title,
            poster_path = it.poster_path,
            rating = it.rating,
            release_date = it.release_date
        )
    }
}



data class NetworkTopRatedMovie(
    val id: Int,
    val title: String,
    val poster_path: String,
    @Json(name ="vote_average")
    val rating: Float,
    val release_date: String
)

fun NetworkTopRatedMoviesContainer.asDatabaseModel(): List<DatabaseTopRatedMovie>{
    return results.map {
        DatabaseTopRatedMovie(
            id = it.id,
            title = it.title,
            poster_path = it.poster_path,
            rating = it.rating,
            release_date = it.release_date
        )
    }
}
