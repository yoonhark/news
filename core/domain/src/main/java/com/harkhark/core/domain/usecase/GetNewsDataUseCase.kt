package com.harkhark.core.domain.usecase

import com.harkhark.core.domain.model.NewsData
import com.harkhark.core.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.merge
import timber.log.Timber
import javax.inject.Inject

class GetNewsDataUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
) {
    suspend operator fun invoke(isKr: Boolean): Flow<List<NewsData>> = flow {
        //DB 데이터 방출
        newsRepository.getLocalNews().collect { localNews ->
            emit(localNews.sortedByDescending { it.publishedAt })
        }

        //최신 데이터 방출
        try {
            newsRepository.getLatestNews(isKr).collect { latestNews ->
                val localNews = newsRepository.getLocalNews().firstOrNull() ?: emptyList()
                val newNews = latestNews.filter { latestItem ->
                    localNews.none { localItem -> localItem.url == latestItem.url }
                }

                if (newNews.isNotEmpty()) {
                    newsRepository.saveNews(newNews)
                    val sortedNews = (localNews + newNews).sortedByDescending { it.publishedAt }
                    emit(sortedNews)  // 로컬 데이터 + 새로운 뉴스 방출
                }
            }
        } catch (e: Exception) {
            Timber.e("Failed to fetch latest news, using local data: ${e.message}")
        }
    }.flowOn(Dispatchers.IO)
}