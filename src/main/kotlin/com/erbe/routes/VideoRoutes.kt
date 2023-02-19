package com.erbe.routes

import com.erbe.models.Items
import com.erbe.storage.video.videoContentTopicLatest
import com.erbe.storage.video.videoContentTopicStorage
import com.erbe.storage.video.videoDetail
import com.erbe.storage.video.videoTopicContentLatest
import com.erbe.storage.video.videoTopicContentStorage
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
                val video = videoContentTopicStorage()
                if (video.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(video))
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
                val video = videoContentTopicLatest()
                if (video.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(video))
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
                val video = videoTopicContentStorage(category)
                if (video != null) {
                    val response = successRespond(HttpStatusCode.OK, video)
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
                val video = videoTopicContentLatest()
                if (video.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(video))
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
                val video = videoDetail(id)
                if (video != null) {
                    val response = successRespond(HttpStatusCode.OK, video)
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
                val video = videoTopicStorage
                if (video.isNotEmpty()) {
                    val response = successRespond(HttpStatusCode.OK, Items(video))
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