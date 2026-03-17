package io.configdog.api.controllers

import io.configdog.api.dto.CreateProjectRequest
import io.configdog.service.ProjectService
import io.javalin.http.Context
import io.javalin.http.bodyAsClass

object ProjectController {
    val service = ProjectService()

    fun getAllProjects(ctx: Context) {
        println("Getting projects")
        ctx.json(service.getAllProjects())
    }

    fun createProject(ctx: Context) {
        val request = ctx.bodyAsClass<CreateProjectRequest>()
        service.createProject(request.name, request.description)
    }
}