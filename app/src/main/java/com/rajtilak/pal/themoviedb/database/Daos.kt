package com.rajtilak.pal.themoviedb.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UpcomingMoviesDao {

    @Query("SELECT * FROM upcoming_movies")
    fun getMovies(): LiveData<List<DatabaseUpcomingMovie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(videos: List<DatabaseUpcomingMovie>)

}