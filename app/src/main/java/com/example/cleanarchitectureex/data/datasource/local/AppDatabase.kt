package com.example.cleanarchitectureex.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.cleanarchitectureex.data.datasource.local.dao.ContentDAO
import com.example.cleanarchitectureex.data.model.entity.ContentEntity

@Database([ContentEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contentDao(): ContentDAO

}