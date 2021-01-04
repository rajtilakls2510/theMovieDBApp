package com.rajtilak.pal.themoviedb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private lateinit var INSTANCE: TMDBDatabase

@Database(entities = [DatabaseUpcomingMovie::class, DatabaseTopRatedMovie::class], version = 1)
abstract class TMDBDatabase: RoomDatabase() {

    abstract val upcomingMoviesDao: UpcomingMoviesDao

    abstract val topRatedMoviesDao: TopRatedMoviesDao
}

fun getDatabase(context: Context): TMDBDatabase {
    synchronized(TMDBDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                TMDBDatabase::class.java,
                "tmdb_database").build()
        }
    }
    return INSTANCE
}