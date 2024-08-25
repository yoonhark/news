package com.harkhark.core.data.repository

import com.harkhark.core.data.datasource.NewsLocalDataSource
import com.harkhark.core.data.datasource.NewsRemoteDataSource
import com.harkhark.core.data.mapper.toNewsData
import com.harkhark.core.data.mapper.toNewsEntity
import com.harkhark.core.domain.model.NewsData
import com.harkhark.core.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val remoteDataSource: NewsRemoteDataSource,
    private val localDataSource: NewsLocalDataSource,
) : NewsRepository {

    override suspend fun getLatestNews(isKr: Boolean): Flow<List<NewsData>> = flow {
        val response = remoteDataSource.fetchNews(isKr)
        emit(response.articles.map { it.toNewsData(isKr) })
    }

    override suspend fun getLocalNews(): Flow<List<NewsData>> = flow {
        val localData = localDataSource.getNews().firstOrNull()
        if (localData?.isNotEmpty() == true)
            emit(localData.map { it.toNewsData() })
    }

    override suspend fun saveNews(news: List<NewsData>) {
        val entity = news.map { it.toNewsEntity() }
        localDataSource.saveNews(entity)
    }
}