package com.erbe.models

import kotlinx.serialization.Serializable

@Serializable
data class Content(
    val id: String,
    val title: String,
    val subtitle: String,
    val content: String,
    val image: String,
    val publishDate: String,
    val time: String,
    val topic: Topic,
    val url: String
)