package com.harkhark.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey val url: String,
    val title: String,
    val urlToImage: String,
    val publishedAt: String,
    var isRead: Boolean = false,
    var isKr: Boolean = true,
)