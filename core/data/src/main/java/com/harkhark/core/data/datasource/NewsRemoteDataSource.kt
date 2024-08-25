package com.harkhark.core.data.datasource

import com.harkhark.core.data.BuildConfig
import com.harkhark.core.data.mapper.toNewsData
import com.harkhark.core.network.api.NewsApi
import com.harkhark.core.network.model.NewsResponse
import timber.log.Timber
import javax.inject.Inject

interface NewsRemoteDataSource {
    suspend fun fetchNews(isKr: Boolean): NewsResponse
}

class NewsRemoteDataSourceImpl @Inject constructor(
    private val newsApi: NewsApi,
) : NewsRemoteDataSource {

    override suspend fun fetchNews(isKr: Boolean): NewsResponse {
        val apiKey = BuildConfig.API_KEY
        return try {
            if (isKr) {
                newsApi.getTopHeadlines(apiKey = apiKey)
            } else {
                newsApi.getTopHeadlinesBySource(apiKey = apiKey)
            }
        } catch (e: Exception) {
            Timber.e("Network error: ${e.message}")
            throw e
        }
    }
}