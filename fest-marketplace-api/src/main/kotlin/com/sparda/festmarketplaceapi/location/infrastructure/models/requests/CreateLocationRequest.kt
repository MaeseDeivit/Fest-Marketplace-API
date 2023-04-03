package com.sparda.festmarketplaceapi.location.infrastructure.models.requests

import com.sparda.festmarketplaceapi.shared.infrastructure.models.requests.GlobalRequest
import jakarta.validation.constraints.Size

data class CreateLocationRequest(
   @field:Size(min=3, max=40)
   val locationName: String
) : GlobalRequest()