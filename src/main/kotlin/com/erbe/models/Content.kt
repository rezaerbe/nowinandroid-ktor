package com.erbe.models

import com.erbe.utils.getId
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Content(
    val id: String = getId(),
    val title: String,
    val subtitle: String,
    val content: String,
    val image: String,
    val date: LocalDate,
    val time: String,
    val topic: Topic,
    val url: String?
)