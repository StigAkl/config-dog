package io.configdog.api.dto

import io.configdog.domain.Environment

data class CreateEnvironmentRequest(val name: String)
data class EnvironmentResponse(val environment: Environment)