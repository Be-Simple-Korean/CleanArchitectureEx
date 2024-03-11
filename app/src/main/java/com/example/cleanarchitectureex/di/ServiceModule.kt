package com.example.cleanarchitectureex.di

import com.example.cleanarchitectureex.data.datasource.local.AppDatabase
import com.example.cleanarchitectureex.data.datasource.local.dao.ContentDAO
import com.example.cleanarchitectureex.data.datasource.remote.ContentService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun providesRetrofitService(retrofit: Retrofit): ContentService =
        retrofit.create(ContentService::class.java)
}