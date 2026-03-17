package io.configdog.api.dto

import io.configdog.domain.Project

data class CreateProjectRequest(
    val name: String,
    val description: String
)

data class ProjectResponse(val project: Project)