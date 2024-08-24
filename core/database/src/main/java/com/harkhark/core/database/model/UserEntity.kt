package com.harkhark.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "users",
)
data class UserEntity(
    @PrimaryKey
    val userid: String,
    val name: String,
    val age: Int,
    @ColumnInfo(defaultValue = "")
    val desc: String,
)