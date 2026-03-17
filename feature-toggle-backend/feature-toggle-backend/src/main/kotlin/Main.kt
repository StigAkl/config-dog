package io.configdog

import io.configdog.api.controllers.FlagController
import io.configdog.api.routes.configDogRoutes
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.json.JavalinJackson

fun main() {
    Javalin.create { config ->
        config.jsonMapper(JavalinJackson())
        config.routes.apiBuilder {
            path("api") {
                configDogRoutes(FlagController())
            }
        }
    }.start(7070)
}