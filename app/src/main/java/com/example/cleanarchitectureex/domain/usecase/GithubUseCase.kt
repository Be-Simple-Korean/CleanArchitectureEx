package com.example.cleanarchitectureex.domain.usecase

import com.example.cleanarchitectureex.domain.model.Item
import com.example.cleanarchitectureex.domain.repository.GithubRepository
import com.example.cleanarchitectureex.presenter.ui.ViewState
import javax.inject.Inject

class GithubUseCase @Inject constructor(private val githubRepository: GithubRepository) {

    suspend fun getRepositories(q: String) : ViewState<List<Item>> {
        return try {
            var items = githubRepository.getRepositories(q)
            if (items != null) {
                ViewState.Success(items)
            } else {
                ViewState.Error("Error fetching repositories")
            }
        } catch (e: Exception) {
            ViewState.Error(e.message.toString())
        }
    }
}