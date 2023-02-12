package com.erbe.utils

import com.erbe.models.Error
import com.erbe.models.Success
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond
import java.time.LocalDate
import java.util.UUID

fun getId(): String {
    return UUID.randomUUID().toString()
}

fun date(year: Int, month: Int, dayOfMonth: Int): String {
    return LocalDate.of(year, month, dayOfMonth).toString()
}

fun contentArticle(content: String): String {
    val url = "http://192.168.45.125:8080/static/article/"
    return url + content
}

fun contentPodcast(content: String): String {
    val url = "http://192.168.45.125:8080/static/podcast/"
    return url + content
}

fun contentVideo(content: String): String {
    val url = "http://192.168.45.125:8080/static/video/"
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