package com.example.cleanarchitectureex.presenter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitectureex.domain.model.Item
import com.example.cleanarchitectureex.domain.usecase.GithubUseCase
import com.example.cleanarchitectureex.presenter.ui.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val githubUseCase: GithubUseCase) : ViewModel() {
    val data = MutableLiveData<List<Item>>()
    val isLoading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    fun requestRepositories() {
        viewModelScope.launch {
            isLoading.value = true
            delay(3000)
            when (val result = githubUseCase.getRepositories("mvvm")) {
                is ViewState.Success -> {
                    delay(3000)
                    isLoading.value = false
                    data.value = result.data
                }

                is ViewState.Loading -> {
                    isLoading.value = true
                }

                is ViewState.Error -> {
                    delay(3000)
                    isLoading.value = false
                    errorMessage.value = result.message
                }
            }
        }
    }
}