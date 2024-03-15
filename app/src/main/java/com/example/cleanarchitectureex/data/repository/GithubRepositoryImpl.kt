package com.example.cleanarchitectureex.data.repository

import com.example.cleanarchitectureex.data.datasource.remote.RepositoryService
import com.example.cleanarchitectureex.data.model.ItemDTO
import com.example.cleanarchitectureex.data.model.ItemMapper.toItem
import com.example.cleanarchitectureex.domain.model.Item
import com.example.cleanarchitectureex.domain.repository.GithubRepository
import javax.inject.Inject


class GithubRepositoryImpl @Inject constructor(private val repositoryService: RepositoryService) :
    GithubRepository {
    override suspend fun getRepositories(q :String): List<Item> {
        return repositoryService.getRepositories(q).items.map {
            it.toItem()
        };
    }
}