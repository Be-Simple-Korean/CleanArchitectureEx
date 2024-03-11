package com.example.cleanarchitectureex.domain.model

import java.io.Serializable

data class Content(
    val id: Int? = null,
    val title: String
) : Serializable
