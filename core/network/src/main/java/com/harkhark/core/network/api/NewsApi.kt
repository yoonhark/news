package com.harkhark.core.network.api

import com.harkhark.core.network.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "kr",
        @Query("apiKey") apiKey: String
    ): NewsResponse

    @GET("top-headlines")
    suspend fun getTopHeadlinesBySource(
        @Query("sources") sources: String = "bbc-news",
        @Query("apiKey") apiKey: String
    ): NewsResponse
}