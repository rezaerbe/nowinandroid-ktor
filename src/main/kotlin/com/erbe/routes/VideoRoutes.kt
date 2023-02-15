package com.erbe.routes

import com.erbe.models.Items
import com.erbe.storage.video.videoStorage
import com.erbe.storage.video.videoTopicStorage
import com.erbe.utils.errorRespond
import com.erbe.utils.successRespond
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Route.videoRouting() {
    route("/video") {
        get {
            try {
                if (videoStorage.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(videoStorage))
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
                if (videoStorage.isNotEmpty()) {
                    val video = videoStorage.take(5)
                    val response = successRespond(HttpStatusCode.OK, video)
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
                val topic = videoTopicStorage.find { it.tag == category }
                    ?: return@get call.errorRespond(HttpStatusCode.NotFound)
                val video = videoStorage.filter { it.topic == topic }
                if (video.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, video)
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
                val topic = videoTopicStorage.find { it.tag == category }
                    ?: return@get call.errorRespond(HttpStatusCode.NotFound)
                val video = videoStorage.filter { it.topic == topic }.take(5)
                if (video.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, video)
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
                val video = videoStorage.find { it.id == id }
                    ?: return@get call.errorRespond(HttpStatusCode.NotFound)
                val response = successRespond(HttpStatusCode.OK, video)
                call.respond(response.first, response.second)
            } catch (e: Exception) {
                call.errorRespond(HttpStatusCode.InternalServerError)
            }
        }

        get("tag") {
            try {
                if (videoTopicStorage.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(videoTopicStorage))
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