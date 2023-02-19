package com.erbe.routes

import com.erbe.models.Items
import com.erbe.storage.article.articleContentTopicLatest
import com.erbe.storage.article.articleContentTopicStorage
import com.erbe.storage.article.articleDetail
import com.erbe.storage.article.articleTopicContentLatest
import com.erbe.storage.article.articleTopicContentStorage
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
                val article = articleContentTopicStorage()
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

        get("latest") {
            try {
                val article = articleContentTopicLatest()
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

        get("tag/{category?}") {
            try {
                val category = call.parameters["category"] ?: return@get call.errorRespond(HttpStatusCode.BadRequest)
                val article = articleTopicContentStorage(category)
                if (article != null) {
                    val response = successRespond(HttpStatusCode.OK, article)
                    call.respond(response.first, response.second)
                } else {
                    call.errorRespond(HttpStatusCode.NotFound)
                }
            } catch (e: Exception) {
                call.errorRespond(HttpStatusCode.InternalServerError)
            }
        }

        get("tag/latest") {
            try {
                val article = articleTopicContentLatest()
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
                val article = articleDetail(id)
                if (article != null) {
                    val response = successRespond(HttpStatusCode.OK, article)
                    call.respond(response.first, response.second)
                } else {
                    call.errorRespond(HttpStatusCode.NotFound)
                }
            } catch (e: Exception) {
                call.errorRespond(HttpStatusCode.InternalServerError)
            }
        }

        get("tag") {
            try {
                val article = articleTopicStorage
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
    }
}