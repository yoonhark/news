package com.harkhark.core.domain.repository

import com.harkhark.core.domain.model.NewsData
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews(): Flow<List<NewsData>>
}