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

    private val _viewState = MutableLiveData<ViewState<List<Item>>>()
    val viewState: LiveData<ViewState<List<Item>>> = _viewState

    init {
        _itemList.value = list
    }

    fun requestRepositories() {
        viewModelScope.launch {
            _viewState.value = ViewState.Loading // 로딩 시작
            delay(3000)
            when (val result = githubUseCase.getRepositories("mvvm")) {
                is ViewState.Success -> {
                    delay(3000)
                    _viewState.value = ViewState.Success(result.data) // 성공 상태
//                    list = result.data.toMutableList()
                }

                is ViewState.Error -> {
                    delay(3000)
                    _viewState.value = ViewState.Error(result.message) // 에러 상태
                }

                else -> {}
            }
        }
    }
}