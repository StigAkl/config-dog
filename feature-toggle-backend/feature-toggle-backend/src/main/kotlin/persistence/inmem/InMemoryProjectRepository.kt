package io.configdog.persistence.inmem

import io.configdog.domain.Project
import io.configdog.persistence.ProjectRepository

object InMemoryProjectRepository: ProjectRepository {
    override fun getAll(): List<Project> {
        return InMemoryDatabase.projects.values.toList()
    }

    override fun getById(id: String): Project? {
        return InMemoryDatabase.projects[id]
    }

    override fun create(item: Project) {
        TODO("Not yet implemented")
    }

    override fun update(item: Project) {
        TODO("Not yet implemented")
    }

    override fun delete(item: Project) {
        TODO("Not yet implemented")
    }
}