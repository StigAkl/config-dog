package io.configdog.api.routes

import io.configdog.api.controllers.FlagController
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post

fun flagRoutes(controller: FlagController) {
    path("flags") {
        get("/") { ctx -> controller.getAll(ctx) }
        get("{id}") { ctx -> controller.getById(ctx) }

        post("/") { ctx -> controller.create(ctx) }
        
    }
}