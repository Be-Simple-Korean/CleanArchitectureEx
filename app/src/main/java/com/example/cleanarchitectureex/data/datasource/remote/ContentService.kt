package com.example.cleanarchitectureex.data.datasource.remote

import com.example.cleanarchitectureex.data.model.dto.ListResponse
import retrofit2.http.GET

interface ContentService {

    @GET("/search/repositories")
    suspend fun getList(): ListResponse
}