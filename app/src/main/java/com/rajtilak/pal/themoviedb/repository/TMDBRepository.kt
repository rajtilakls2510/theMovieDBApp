package com.rajtilak.pal.themoviedb.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.rajtilak.pal.themoviedb.database.TMDBDatabase
import com.rajtilak.pal.themoviedb.database.asTopRatedDomainModel
import com.rajtilak.pal.themoviedb.database.asUpcomingDomainModel
import com.rajtilak.pal.themoviedb.domain.MoviePreview
import com.rajtilak.pal.themoviedb.network.TMDBApi
import com.rajtilak.pal.themoviedb.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TAG = "TMDBRepository"
class TMDBRepository(private val database: TMDBDatabase) {

    val upcomingMovies: LiveData<List<MoviePreview>> = Transformations.map(database.upcomingMoviesDao.getMovies()) {
        it.asUpcomingDomainModel()
    }
    val topRatedMovies: LiveData<List<MoviePreview>> = Transformations.map(database.topRatedMoviesDao.getMovies()) {
        it.asTopRatedDomainModel()
    }

    suspend fun refreshUpcomingMovies() {
        withContext(Dispatchers.IO) {
            Log.d(TAG,"refresh movies is called");
            val movies = TMDBApi.retrofitService.getUpcomingMovies(TMDBApi.API_KEY)
            Log.d(TAG, "Movies received: "+movies.results.size+". Inserting in DB")

            database.upcomingMoviesDao.insertAll(movies.asDatabaseModel())
            Log.d(TAG, "DB Insertion Complete")
        }
    }
    suspend fun refreshTopRatedMovies() {
        withContext(Dispatchers.IO) {
            Log.d(TAG,"refresh movies is called");
            val movies = TMDBApi.retrofitService.getTopRatedMovies(TMDBApi.API_KEY)
            Log.d(TAG, "Movies received: "+movies.results.size+". Inserting in DB")

            database.topRatedMoviesDao.insertAll(movies.asDatabaseModel())
            Log.d(TAG, "DB Insertion Complete")
        }
    }
}