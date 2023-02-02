package com.erbe.models

import kotlinx.serialization.Serializable

@Serializable
data class Data<T>(
    val data: T
)