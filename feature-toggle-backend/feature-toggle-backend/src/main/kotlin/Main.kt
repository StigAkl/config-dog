package io.configdog

import io.configdog.api.controllers.FlagController
import io.configdog.api.routes.flagRoutes
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.json.JavalinJackson

fun main() {
    Javalin.create { config ->
        config.jsonMapper(JavalinJackson())
        config.routes.apiBuilder {
            path("api") {
                flagRoutes(FlagController())
            }
        }
    }.start(7070)
}