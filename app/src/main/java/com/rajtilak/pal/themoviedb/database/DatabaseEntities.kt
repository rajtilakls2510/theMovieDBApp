package com.rajtilak.pal.themoviedb.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rajtilak.pal.themoviedb.domain.MoviePreview

@Entity(tableName = "upcoming_movies")
data class DatabaseUpcomingMovie constructor(
    @PrimaryKey
    val id: Int,
    val title: String,
    val poster_path: String,
    val rating: Float,
    val release_date: String
)

fun List<DatabaseUpcomingMovie>.asDomainModel(): List<MoviePreview> {
    return map {
        MoviePreview(
            id = it.id,
            title = it.title,
            poster_path = it.poster_path,
            rating = it.rating,
            release_date = it.release_date
        )
    }
}