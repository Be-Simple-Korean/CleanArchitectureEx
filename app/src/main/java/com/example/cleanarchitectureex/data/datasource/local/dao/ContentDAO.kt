package com.example.cleanarchitectureex.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cleanarchitectureex.data.model.entity.ContentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContentDAO {

    @Query("SELECT * FROM CONTENT")
    fun selectAll() : Flow<List<ContentEntity>>
}