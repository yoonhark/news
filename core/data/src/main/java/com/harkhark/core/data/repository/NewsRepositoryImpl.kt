package com.harkhark.core.data.repository

import com.harkhark.core.common.config.AppConfigProvider
import com.harkhark.core.data.mapper.toNewsData
import com.harkhark.core.domain.model.NewsData
import com.harkhark.core.domain.repository.NewsRepository
import com.harkhark.core.network.api.NewsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
    private val appConfigProvider: AppConfigProvider
) : NewsRepository {

    override suspend fun getNews(): Flow<List<NewsData>> = flow {
        val apiKey = appConfigProvider.get().apiKey
        val response = newsApi.getTopHeadlines(apiKey = apiKey)
        emit(response.articles.map { it.toNewsData() })
    }
}