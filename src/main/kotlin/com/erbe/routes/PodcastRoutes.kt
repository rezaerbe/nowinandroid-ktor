package com.erbe.routes

import com.erbe.models.Data
import com.erbe.models.Items
import com.erbe.storage.podcast.podcastStorage
import com.erbe.utils.errorRespond
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
                    call.respond(HttpStatusCode.OK, Data(Items(podcastStorage)))
                } else {
                    call.errorRespond(HttpStatusCode.NotFound)
                }
            } catch (e: Exception) {
                call.errorRespond(HttpStatusCode.InternalServerError)
            }
        }
    }
}