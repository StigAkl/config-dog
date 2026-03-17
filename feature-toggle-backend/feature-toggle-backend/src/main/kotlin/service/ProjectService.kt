package io.configdog.service

import io.configdog.domain.Project
import io.configdog.persistence.inmem.InMemoryProjectRepository
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class ProjectService() {
    init {
        println("Service initialized")
    }
    fun getAllProjects(): List<Project> {
        return InMemoryProjectRepository.getAll()
    }

    fun getProjectById(id: String) {
        InMemoryProjectRepository.getById(id)
    }

    @OptIn(ExperimentalUuidApi::class)
    fun createProject(name: String, description: String): Project {
        val newProject = Project(Uuid.random().toString(), name)
        InMemoryProjectRepository.create(newProject)
        return newProject
    }
}
