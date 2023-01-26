package com.erbe

import com.erbe.plugins.configureHTTP
import com.erbe.plugins.configureRouting
import com.erbe.plugins.configureSerialization
import io.ktor.server.application.Application

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureSerialization()
    configureHTTP()
    configureRouting()
}