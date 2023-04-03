package com.sparda.festmarketplaceapi.fest.infrastructure.models.requests

import com.sparda.festmarketplaceapi.shared.infrastructure.models.requests.GlobalRequest
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.util.UUID

data class CreateFestRequest(
    @field:Size(min = 3, max = 60)
    val festName: String,

    @field:NotNull
    val locationId: UUID
) : GlobalRequest()