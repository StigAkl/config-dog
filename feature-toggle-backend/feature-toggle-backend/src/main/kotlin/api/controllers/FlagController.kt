package io.configdog.api.controllers

import io.configdog.persistence.inmem.InMemoryFeatureFlagRepository
import io.configdog.persistence.inmem.InMemoryProjectRepository
import io.configdog.service.FeatureFlagService
import io.javalin.http.Context

class FlagController {
    val featureFlagService = FeatureFlagService(
        InMemoryFeatureFlagRepository,
        projectRepository = InMemoryProjectRepository
    )
    fun getAll(ctx: Context) {
        ctx.json(InMemoryFeatureFlagRepository.getAll())
    }

    fun getById(ctx: Context) {
        val id = ctx.pathParam("id")
        val flag = InMemoryFeatureFlagRepository.getById(id)
        if(flag == null) {
            ctx.status(404).result("Not found")
            return
        }
        ctx.json(flag)
    }
}