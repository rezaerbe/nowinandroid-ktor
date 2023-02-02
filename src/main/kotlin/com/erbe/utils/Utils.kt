package com.erbe.utils

import java.time.LocalDate

fun contentArticle(content: String): String {
    val url = "http://192.168.45.125:8080/static/article/"
    return url + content
}

fun image(image: String): String {
    val url = "https://miro.medium.com/"
    return url + image
}

fun date(year: Int, month: Int, dayOfMonth: Int): String {
    return LocalDate.of(year, month, dayOfMonth).toString()
}