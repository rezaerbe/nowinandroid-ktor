package com.erbe.utils

import com.erbe.models.Error
import com.erbe.models.Success
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond
import kotlinx.datetime.LocalDate

const val base_url = "http://192.168.183.125:8080"

fun date(year: Int, month: Int, dayOfMonth: Int): LocalDate {
    return LocalDate(year, month, dayOfMonth)
}

fun contentArticle(content: String): String {
    val url = "$base_url/static/article/"
    return url + content
}

fun contentPodcast(content: String): String {
    val url = "$base_url/static/podcast/"
    return url + content
}

fun contentVideo(content: String): String {
    val url = "$base_url/static/video/"
    return url + content
}

fun <T> successRespond(httpStatusCode: HttpStatusCode, data: T): Pair<HttpStatusCode, Success<T>> {
    return httpStatusCode to
            Success(
                httpStatusCode.value,
                httpStatusCode.description,
                data
            )
}

suspend fun ApplicationCall.errorRespond(httpStatusCode: HttpStatusCode) {
    return this.respond(
        httpStatusCode,
        Error(
            httpStatusCode.value,
            httpStatusCode.description
        )
    )
}