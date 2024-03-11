package com.example.cleanarchitectureex.di

import com.example.cleanarchitectureex.data.datasource.local.AppDatabase
import com.example.cleanarchitectureex.data.datasource.local.dao.ContentDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Singleton
    @Provides
    fun providesContentDao(appDatabase: AppDatabase) = appDatabase.contentDao()
}