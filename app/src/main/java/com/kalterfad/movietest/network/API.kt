package com.kalterfad.movietest.network


import com.kalterfad.movietest.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("./svc/movies/v2/reviews/all.json")
    suspend fun getAllMovies(
        @Query("offset") offset: Int,
        @Query("api-key") api_key: String = BuildConfig.API
    ): Response<APIResponse>

}