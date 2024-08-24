package com.harkhark.core.data.mapper

import com.harkhark.core.domain.model.NewsData
import com.harkhark.core.network.model.Article

fun Article.toNewsData(): NewsData {
    return NewsData(
        title = title,
        urlToImage = urlToImage ?: "",
        publishedAt = publishedAt
    )
}