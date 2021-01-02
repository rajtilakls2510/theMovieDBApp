package com.rajtilak.pal.themoviedb.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object TMDBApi {
    val retrofitService : TMDBApiService by lazy {
        retrofit.create(TMDBApiService::class.java)
    }
    const val API_KEY = "bce14f5ba33678cf8674b87e4cbe17fc"
}

interface TMDBApiService {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") api_key: String): NetworkUpcomingMoviesContainer
}


