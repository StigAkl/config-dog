package io.configdog.api.routes

import io.configdog.api.controllers.FlagController
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path

fun flagRoutes(controller: FlagController) {
    path("flags") {
        get("/") { ctx -> controller.getAll(ctx) }
        get("{id}") { ctx -> controller.getById(ctx) }
    }
}