package io.configdog.api.controllers

import io.configdog.api.dto.CreateFeatureFlagRequest
import io.configdog.persistence.inmem.InMemoryFeatureFlagRepository
import io.configdog.persistence.inmem.InMemoryProjectRepository
import io.configdog.service.FeatureFlagService
import io.javalin.http.Context
import io.javalin.http.bodyAsClass

class FlagController {
    val featureFlagService = FeatureFlagService(
        InMemoryFeatureFlagRepository,
        projectRepository = InMemoryProjectRepository
    )

    fun getAll(ctx: Context) {
        val all = featureFlagService.getAllFlags()
        ctx.json(all)
    }

    fun getById(ctx: Context) {
        val id = ctx.pathParam("id")
        val result = featureFlagService.getById(id)
        if(result == null) {
            ctx.status(404).result("Not found")
            return
        }
        ctx.json(result)
    }

    fun create(ctx: Context) {
        val request = ctx.bodyAsClass<CreateFeatureFlagRequest>()
        val created = featureFlagService.createFlag(
            request.name,
            request.key,
            request.description,
            request.projectId
        )
        ctx.json(created)
    }
}