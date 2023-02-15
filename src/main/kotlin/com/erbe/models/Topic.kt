package com.erbe.models

import com.erbe.utils.getId
import kotlinx.serialization.Serializable

@Serializable
data class Topic(
    val id: String = getId(),
    val tag: String,
    val name: String,
    val description: String,
    val image: String,
    val total: String,
    val url: String
)