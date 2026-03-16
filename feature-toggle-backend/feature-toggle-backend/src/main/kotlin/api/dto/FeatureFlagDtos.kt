package io.configdog.api.dto


data class CreateFeatureFlagRequest(
    val name: String,
    val key: String,
    val description: String,
    val projectId: String,
)