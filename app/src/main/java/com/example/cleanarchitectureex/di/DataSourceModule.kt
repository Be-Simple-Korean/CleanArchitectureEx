package com.example.cleanarchitectureex.di

import com.example.cleanarchitectureex.data.datasource.remote.RemoteDataSource
import com.example.cleanarchitectureex.data.datasource.remote.RepositoryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providesRemoteDataSource(repositoryService: RepositoryService) : RemoteDataSource{
        return RemoteDataSource(repositoryService)
    }
}