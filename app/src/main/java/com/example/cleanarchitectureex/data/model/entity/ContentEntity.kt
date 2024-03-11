package com.example.cleanarchitectureex.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Content")
data class ContentEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo
    val name: String
)
