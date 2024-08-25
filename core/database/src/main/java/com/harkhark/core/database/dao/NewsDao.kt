package com.harkhark.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.harkhark.core.database.model.NewsEntity
import kotlinx.coroutines.flow.Flow

/**
 * DAO for [NewsEntity] access
 */
@Dao
interface NewsDao {
    @Query("SELECT * FROM news")
    fun getNews(): Flow<List<NewsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(news: List<NewsEntity>)
}