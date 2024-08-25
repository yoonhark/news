package com.harkhark.core.domain.model

data class NewsData(
    val title: String,
    val urlToImage: String,
    val publishedAt: String,
    val url: String,
    val isKr: Boolean,
    var isRead: Boolean = false,
)
