package com.erbe.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.http.content.resources
import io.ktor.server.http.content.static
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        static("/static") {
            resources("static")
        }
    }
}