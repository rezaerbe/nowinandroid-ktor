package com.erbe.plugins

import com.erbe.routes.articleRouting
import com.erbe.routes.podcastRouting
import com.erbe.routes.videoRouting
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
            call.respondText("Now In Android")
        }
        static("/static") {
            resources("static")
        }
        articleRouting()
        podcastRouting()
        videoRouting()
    }
}