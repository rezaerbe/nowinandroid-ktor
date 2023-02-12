package com.erbe.routes

import com.erbe.models.Items
import com.erbe.storage.podcast.podcastStorage
import com.erbe.utils.errorRespond
import com.erbe.utils.successRespond
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Route.podcastRouting() {
    route("/podcasts") {
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
    }
}