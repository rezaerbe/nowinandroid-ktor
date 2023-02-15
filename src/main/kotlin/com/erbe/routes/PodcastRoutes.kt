package com.erbe.routes

import com.erbe.models.Items
import com.erbe.storage.podcast.podcastStorage
import com.erbe.storage.podcast.podcastTopicStorage
import com.erbe.utils.errorRespond
import com.erbe.utils.successRespond
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Route.podcastRouting() {
    route("/podcast") {
        get {
            try {
                if (podcastStorage.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(podcastStorage))
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
                if (podcastStorage.isNotEmpty()) {
                    val podcast = podcastStorage.take(5)
                    val response = successRespond(HttpStatusCode.OK, podcast)
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
                val topic = podcastTopicStorage.find { it.tag == category }
                    ?: return@get call.errorRespond(HttpStatusCode.NotFound)
                val podcast = podcastStorage.filter { it.topic == topic }
                if (podcast.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, podcast)
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
                val topic = podcastTopicStorage.find { it.tag == category }
                    ?: return@get call.errorRespond(HttpStatusCode.NotFound)
                val podcast = podcastStorage.filter { it.topic == topic }.take(5)
                if (podcast.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, podcast)
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
                val podcast = podcastStorage.find { it.id == id }
                    ?: return@get call.errorRespond(HttpStatusCode.NotFound)
                val response = successRespond(HttpStatusCode.OK, podcast)
                call.respond(response.first, response.second)
            } catch (e: Exception) {
                call.errorRespond(HttpStatusCode.InternalServerError)
            }
        }

        get("tag") {
            try {
                if (podcastTopicStorage.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(podcastTopicStorage))
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