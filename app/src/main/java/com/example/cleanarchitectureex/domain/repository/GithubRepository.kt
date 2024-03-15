package com.example.cleanarchitectureex.domain.repository

import com.example.cleanarchitectureex.data.model.ItemDTO
import com.example.cleanarchitectureex.domain.model.Item


interface GithubRepository {

    suspend fun getRepositories(q: String): List<Item>
}