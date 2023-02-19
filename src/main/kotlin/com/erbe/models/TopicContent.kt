package com.erbe.models

import kotlinx.serialization.Serializable

@Serializable
data class TopicContent(
    val id: String,
    val tag: String,
    val name: String,
    val description: String,
    val image: String,
    val total: String,
    val itemContent: List<Content>,
    val url: String,
)