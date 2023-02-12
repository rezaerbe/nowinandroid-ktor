package com.erbe.models

import kotlinx.serialization.Serializable

@Serializable
data class Success<T>(
    val code: Int,
    val message: String,
    val data: T
)

@Serializable
data class Items<T>(
    val items: List<T>
)