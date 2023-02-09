package com.erbe.models

import kotlinx.serialization.Serializable

@Serializable
data class Data<T>(
    val data: T
)

@Serializable
data class Items<T>(
    val items: MutableList<T>
)