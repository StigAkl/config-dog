package io.configdog.persistence.inmem

import io.configdog.domain.Environment
import io.configdog.domain.FeatureFlag
import io.configdog.domain.FeatureFlagValue
import io.configdog.domain.Project
import java.util.concurrent.ConcurrentHashMap

object InMemoryDatabase {
    val projects = ConcurrentHashMap<String, Project>(
        mapOf(
            "project-1" to Project(
                id = "project-1",
                name = "Main project"
            )
        )
    )

    val environments = ConcurrentHashMap<String, Environment>(
        mapOf(
            "env-dev" to Environment(
                id = "env-dev",
                projectId = "project-1",
                name = "dev",
                sdkKey = "cdog_dev_123"
            ),
            "env-prod" to Environment(
                id = "env-prod",
                projectId = "project-1",
                name = "prod",
                sdkKey = "cdog_prod_456"
            )
        )
    )

    val featureFlags = ConcurrentHashMap(
        mapOf(
            "flag-1" to FeatureFlag(
                id = "flag-1",
                projectId = "project-1",
                key = "new-checkout",
                name = "New checkout",
                description = "Ny checkout-flyt"
            ),
            "flag-2" to FeatureFlag(
                id = "flag-2",
                projectId = "project-1",
                key = "beta-profile",
                name = "Beta profile",
                description = "Ny profilside"
            )
        )
    )

    val featureFlagValues = ConcurrentHashMap<String, FeatureFlagValue>(
        mapOf(
            "ffv-1" to FeatureFlagValue(
                id = "ffv-1",
                flagId = "flag-1",
                environmentId = "env-dev",
                enabled = true
            ),
            "ffv-2" to FeatureFlagValue(
                id = "ffv-2",
                flagId = "flag-1",
                environmentId = "env-prod",
                enabled = false
            ),
            "ffv-3" to FeatureFlagValue(
                id = "ffv-3",
                flagId = "flag-2",
                environmentId = "env-dev",
                enabled = true
            ),
            "ffv-4" to FeatureFlagValue(
                id = "ffv-4",
                flagId = "flag-2",
                environmentId = "env-prod",
                enabled = true
            )
        )
    )
}