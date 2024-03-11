package com.example.cleanarchitectureex.di

import android.content.Context
import androidx.room.Room
import com.example.cleanarchitectureex.data.datasource.local.AppDatabase
import com.example.cleanarchitectureex.data.datasource.local.dao.ContentDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "test_db"
        ).fallbackToDestructiveMigration().build()
    }
}