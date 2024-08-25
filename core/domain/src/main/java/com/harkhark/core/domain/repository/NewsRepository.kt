package com.harkhark.core.domain.repository

import com.harkhark.core.domain.model.NewsData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface NewsRepository {
//    val newsDatas: StateFlow<List<NewsData>>
//    suspend fun fetchLatestNews(isKr: Boolean)

    suspend fun getLatestNews(isKr: Boolean): Flow<List<NewsData>>
    suspend fun getLocalNews(): Flow<List<NewsData>>
    suspend fun saveNews(news: List<NewsData>)
}