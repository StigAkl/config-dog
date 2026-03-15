package io.configdog.domain

data class Project (
    val id: String,
    val name: String,
)

data class Environment(
    val id: String,
    val name: String,
    val projectId: String,
    val sdkKey: String,
)

data class FeatureFlag(
    val id: String,
    val name: String,
    val key: String,
    val description: String,
    val projectId: String,
)

data class FeatureFlagValue (
    val id: String,
    val flagId: String,
    val environmentId: String,
    val enabled: Boolean,
)