package io.configdog.service

import io.configdog.domain.FeatureFlag
import io.configdog.persistence.FeatureFlagRepository
import io.configdog.persistence.ProjectRepository
import io.javalin.http.BadRequestResponse
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class FeatureFlagService(val featureFlagRepository: FeatureFlagRepository, val projectRepository: ProjectRepository) {

    fun getAllFlags(): List<FeatureFlag> {
        return featureFlagRepository.getAll()
    }

    fun getById(id: String): FeatureFlag? {
        return featureFlagRepository.getById(id)
    }

    @OptIn(ExperimentalUuidApi::class)
    fun createFlag(name: String, key: String, description: String, projectId: String): FeatureFlag {
        projectRepository.getById(projectId) ?: throw BadRequestResponse("Project with id $projectId does not exist")
        val id = Uuid.random().toString()
        val flagToCreate = FeatureFlag(id, name, key, description, projectId)
        featureFlagRepository.create(flagToCreate)
        return flagToCreate
    }
}