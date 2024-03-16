package com.example.cleanarchitectureex.presenter.viewmodel

import androidx.lifecycle.LiveData
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
    private var list = mutableListOf<Item>()

    private val _itemList = MutableLiveData<List<Item>>()
    val itemList: LiveData<List<Item>> = _itemList
    val isLoading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    init {
        _itemList.value = list
    }
    fun requestRepositories() {
        viewModelScope.launch {
            isLoading.value = true
            delay(3000)
            when (val result = githubUseCase.getRepositories("mvvm")) {
                is ViewState.Success -> {
                    delay(3000)
                    isLoading.value = false
                    list = result.data.toMutableList()
                    _itemList.value = list
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