package com.sparda.festmarketplaceapi.location.infrastructure.models.requests

import com.sparda.festmarketplaceapi.shared.infrastructure.models.requests.GlobalRequest

data class CreateLocationRequest(val locationName: String): GlobalRequest()
