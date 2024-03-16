package com.example.cleanarchitectureex.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitectureex.data.datasource.remote.ApiResult
import com.example.cleanarchitectureex.domain.usecase.GithubUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val githubUseCase: GithubUseCase) : ViewModel() {
    fun requestRepositories() {
        viewModelScope.launch {
            var result = githubUseCase.getRepositories("mvvm");
            Log.e("result",result.toString())
        }
    }
}