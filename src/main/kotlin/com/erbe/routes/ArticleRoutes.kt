package com.erbe.routes

import com.erbe.models.Items
import com.erbe.storage.article.articleStorage
import com.erbe.storage.article.articleTopicStorage
import com.erbe.utils.errorRespond
import com.erbe.utils.successRespond
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Route.articleRouting() {
    route("/article") {
        get {
            try {
                if (articleStorage.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(articleStorage))
                    call.respond(response.first, response.second)
                } else {
                    call.errorRespond(HttpStatusCode.NotFound)
                }
            } catch (e: Exception) {
                call.errorRespond(HttpStatusCode.InternalServerError)
            }
        }

        get("latest") {
            try {
                if (articleStorage.isNotEmpty()) {
                    val article = articleStorage.take(5)
                    val response = successRespond(HttpStatusCode.OK, Items(article))
                    call.respond(response.first, response.second)
                } else {
                    call.errorRespond(HttpStatusCode.NotFound)
                }
            } catch (e: Exception) {
                call.errorRespond(HttpStatusCode.InternalServerError)
            }
        }

        get("tag/{category?}") {
            try {
                val category = call.parameters["category"] ?: return@get call.errorRespond(HttpStatusCode.BadRequest)
                val topic = articleTopicStorage.find { it.tag == category }
                    ?: return@get call.errorRespond(HttpStatusCode.NotFound)
                val article = articleStorage.filter { it.topic == topic }
                if (article.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(article))
                    call.respond(response.first, response.second)
                } else {
                    call.errorRespond(HttpStatusCode.NotFound)
                }
            } catch (e: Exception) {
                call.errorRespond(HttpStatusCode.InternalServerError)
            }
        }

        get("tag/{category?}/latest") {
            try {
                val category = call.parameters["category"] ?: return@get call.errorRespond(HttpStatusCode.BadRequest)
                val topic = articleTopicStorage.find { it.tag == category }
                    ?: return@get call.errorRespond(HttpStatusCode.NotFound)
                val article = articleStorage.filter { it.topic == topic }.take(5)
                if (article.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(article))
                    call.respond(response.first, response.second)
                } else {
                    call.errorRespond(HttpStatusCode.NotFound)
                }
            } catch (e: Exception) {
                call.errorRespond(HttpStatusCode.InternalServerError)
            }
        }

        get("{id?}") {
            try {
                val id = call.parameters["id"] ?: return@get call.errorRespond(HttpStatusCode.BadRequest)
                val article = articleStorage.find { it.id == id }
                    ?: return@get call.errorRespond(HttpStatusCode.NotFound)
                val response = successRespond(HttpStatusCode.OK, article)
                call.respond(response.first, response.second)
            } catch (e: Exception) {
                call.errorRespond(HttpStatusCode.InternalServerError)
            }
        }

        get("tag") {
            try {
                if (articleTopicStorage.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(articleTopicStorage))
                    call.respond(response.first, response.second)
                } else {
                    call.errorRespond(HttpStatusCode.NotFound)
                }
            } catch (e: Exception) {
                call.errorRespond(HttpStatusCode.InternalServerError)
            }
        }
    }
}