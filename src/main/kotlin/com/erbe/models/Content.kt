package com.erbe.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Content(
    val id: String,
    val tag: String,
    val title: String,
    val subtitle: String,
    val content: String,
    val image: String,
    val date: LocalDate,
    val time: String,
    val url: String
)