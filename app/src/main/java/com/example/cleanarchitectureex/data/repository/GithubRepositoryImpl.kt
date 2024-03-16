package com.example.cleanarchitectureex.data.repository

import com.example.cleanarchitectureex.data.datasource.remote.ApiResult
import com.example.cleanarchitectureex.data.datasource.remote.RemoteDataSource
import com.example.cleanarchitectureex.data.model.ItemMapper.toItem
import com.example.cleanarchitectureex.domain.model.Item
import com.example.cleanarchitectureex.domain.repository.GithubRepository
import javax.inject.Inject


class GithubRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    GithubRepository {
    override suspend fun getRepositories(q: String): List<Item>? {
        return when (val result = remoteDataSource.getRepositories(q)) {
            is ApiResult.Success -> result.data.map { it.toItem() }
            is ApiResult.Failure -> null // 실패 처리
        }
    }
}