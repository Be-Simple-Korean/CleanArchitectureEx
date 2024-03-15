package com.example.cleanarchitectureex.di

import com.example.cleanarchitectureex.data.datasource.remote.RepositoryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun providesService(retrofit: Retrofit): RepositoryService =
        retrofit.create(RepositoryService::class.java)
}