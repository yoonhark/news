package com.harkhark.core.data.datasource

import com.harkhark.core.database.dao.NewsDao
import com.harkhark.core.database.model.NewsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface NewsLocalDataSource {
    fun getNews(): Flow<List<NewsEntity>>
    suspend fun saveNews(news: List<NewsEntity>)
}

class NewsLocalDataSourceImpl @Inject constructor(
    private val newsDao: NewsDao
) : NewsLocalDataSource {
    override fun getNews(): Flow<List<NewsEntity>> {
        return newsDao.getNews()
    }

    override suspend fun saveNews(news: List<NewsEntity>) {
        newsDao.insertAll(news)
    }
}
