package com.example.cleanarchitectureex.domain.usecase

import com.example.cleanarchitectureex.data.repository.GithubRepositoryImpl
import com.example.cleanarchitectureex.domain.model.Item
import com.example.cleanarchitectureex.domain.repository.GithubRepository
import javax.inject.Inject

class GithubUseCase @Inject constructor(private val githubRepository: GithubRepository) {

    suspend fun getRepositories(q: String): List<Item> {
        return githubRepository.getRepositories(q);
    }
}