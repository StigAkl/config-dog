package io.configdog.persistence

import io.configdog.domain.Environment
import io.configdog.domain.FeatureFlag
import io.configdog.domain.Project

interface Repository<T> {
    fun getAll(): List<T>
    fun getById(id: String): T?
    fun create(item: T)
    fun update(item: T)
    fun delete(item: T)
}

interface ProjectRepository : Repository<Project>
interface FeatureFlagRepository : Repository<FeatureFlag>
interface EnvironmentRepository : Repository<Environment>