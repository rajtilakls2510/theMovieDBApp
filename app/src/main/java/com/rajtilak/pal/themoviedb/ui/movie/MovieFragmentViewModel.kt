package com.rajtilak.pal.themoviedb.ui.movie

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.rajtilak.pal.themoviedb.database.getDatabase
import com.rajtilak.pal.themoviedb.repository.TMDBRepository
import kotlinx.coroutines.launch
import java.io.IOException

class MovieFragmentViewModel(application: Application): AndroidViewModel(application) {

    private val repository = TMDBRepository(getDatabase(application))

    val upcomingMovies = repository.upcomingMovies

    init {
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository() {
        viewModelScope.launch {

            try {

                repository.refreshUpcomingMovies()
            } catch (networkError: IOException) {
                Toast.makeText(getApplication(), "Network Error", Toast.LENGTH_SHORT).show()
            }
        }
    }


    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MovieFragmentViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MovieFragmentViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}