package com.harkhark.core.data.mapper

import com.harkhark.core.domain.model.NewsData
import com.harkhark.core.network.model.Article
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun Article.toNewsData(): NewsData {
    return NewsData(
        title = title,
        urlToImage = urlToImage ?: "",
        publishedAt = formatPublishedDate(publishedAt),
        url = url,
    )
}

/**
 * String 포멧 변경
 */
private fun formatPublishedDate(publishedAt: String): String {
    val zonedDateTime = ZonedDateTime.parse(publishedAt, DateTimeFormatter.ISO_ZONED_DATE_TIME)

    val formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 HH:mm", Locale.getDefault())
    return zonedDateTime.format(formatter)
}