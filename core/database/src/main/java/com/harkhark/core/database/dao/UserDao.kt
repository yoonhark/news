package com.harkhark.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.harkhark.core.database.model.UserEntity
import kotlinx.coroutines.flow.Flow

/**
 * DAO for [UserEntity] access
 */
@Dao
interface UserDao {
    @Query(
        value = """
        SELECT * FROM users
        WHERE userid = :id
    """,
    )
    fun getUserEntity(id: String): Flow<UserEntity>

    @Query(value = "SELECT * FROM users")
    fun getUserEntities(): Flow<List<UserEntity>>

    /**
     * Inserts [topicEntities] into the db if they don't exist, and ignores those that do
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreUsers(topicEntities: List<UserEntity>): List<Long>

    /**
     * Inserts or updates [entities] in the db under the specified primary keys
     */
    @Upsert
    suspend fun upsertUsers(entities: List<UserEntity>)

    /**
     * Deletes rows in the db matching the specified [ids]
     */
    @Query(
        value = """
            DELETE FROM users
            WHERE userid in (:ids)
        """,
    )
    suspend fun deleteUsers(ids: List<String>)
}