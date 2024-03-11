package com.example.cleanarchitectureex.data.model.dto

data class ListResponse(
    val success: Boolean,
    val code: Int,
    val message: String,
    val data: List<ContentDTO>
)

data class ContentResponse(
    val success: Boolean,
    val code: Int,
    val message: String,
    val data: ContentDTO?
)