package com.erbe.routes

import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Route.articleRouting() {
    route("/article") {
        get {

        }
    }
}