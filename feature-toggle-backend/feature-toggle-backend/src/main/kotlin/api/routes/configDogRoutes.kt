package io.configdog.api.routes

import io.configdog.api.controllers.FlagController
import io.configdog.api.controllers.ProjectController
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post

fun configDogRoutes(flagController: FlagController) {
    path("projects") {
        get(ProjectController::getAllProjects)
        post(ProjectController::createProject)
        path("flags") {
            get("/") { ctx -> flagController.getAll(ctx) }
            get("{id}") { ctx -> flagController.getById(ctx) }
            post("/") { ctx -> flagController.create(ctx) }
        }
    }
}