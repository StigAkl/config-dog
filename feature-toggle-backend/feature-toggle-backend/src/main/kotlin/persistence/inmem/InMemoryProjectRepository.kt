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
        InMemoryDatabase.projects[item.id] = item
    }

    override fun update(item: Project) {
        val currentItem = InMemoryDatabase.projects[item.id]
        if(currentItem != null) {
            InMemoryDatabase.projects[item.id] = item
        }
    }

    override fun delete(item: Project) {
        InMemoryDatabase.projects.remove(item.id)
    }
}