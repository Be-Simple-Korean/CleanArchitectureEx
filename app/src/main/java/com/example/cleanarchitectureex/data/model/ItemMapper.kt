package com.example.cleanarchitectureex.data.model

import com.example.cleanarchitectureex.domain.model.Item
import java.util.*

object ItemMapper {

    fun ItemDTO.toItem() = Item(
        id = id ?: -1,
        name = name,
    )

}