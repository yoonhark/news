package com.harkhark.core.domain.usecase

import com.harkhark.core.domain.model.NewsData
import com.harkhark.core.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsDataUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
) {
    suspend operator fun invoke(isKr:Boolean): Flow<List<NewsData>> {
        return newsRepository.getNews(isKr)
    }
}