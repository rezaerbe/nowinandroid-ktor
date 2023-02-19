package com.erbe.routes

import com.erbe.models.Items
import com.erbe.storage.podcast.podcastContentTopicLatest
import com.erbe.storage.podcast.podcastContentTopicStorage
import com.erbe.storage.podcast.podcastDetail
import com.erbe.storage.podcast.podcastTopicContentLatest
import com.erbe.storage.podcast.podcastTopicContentStorage
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
                val podcast = podcastContentTopicStorage()
                if (podcast.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(podcast))
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
                val podcast = podcastContentTopicLatest()
                if (podcast.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(podcast))
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
                val podcast = podcastTopicContentStorage(category)
                if (podcast != null) {
                    val response = successRespond(HttpStatusCode.OK, podcast)
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
                val podcast = podcastTopicContentLatest()
                if (podcast.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(podcast))
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
                val podcast = podcastDetail(id)
                if (podcast != null) {
                    val response = successRespond(HttpStatusCode.OK, podcast)
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
                val podcast = podcastTopicStorage
                if (podcast.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(podcast))
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