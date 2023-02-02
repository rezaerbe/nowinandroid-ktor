package com.erbe.models

import kotlinx.serialization.Serializable

@Serializable
data class Topic(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val total: String,
    val url: String
)