package io.configdog.persistence.inmem

import io.configdog.domain.FeatureFlag
import io.configdog.persistence.FeatureFlagRepository

object InMemoryFeatureFlagRepository: FeatureFlagRepository {

    override fun getAll(): List<FeatureFlag> {
        return InMemoryDatabase.featureFlags.values.toList()
    }

    override fun getById(id: String): FeatureFlag? {
        return InMemoryDatabase.featureFlags[id]
    }

    override fun create(item: FeatureFlag) {
        InMemoryDatabase.featureFlags[item.id] = item
    }

    override fun update(item: FeatureFlag) {
        TODO("Not yet implemented")
    }

    override fun delete(item: FeatureFlag) {
        TODO("Not yet implemented")
    }
}