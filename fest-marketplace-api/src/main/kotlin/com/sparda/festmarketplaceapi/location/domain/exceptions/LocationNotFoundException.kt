package com.sparda.festmarketplaceapi.location.domain.exceptions

import com.sparda.festmarketplaceapi.shared.domain.exceptions.GlobalException
import org.springframework.http.HttpStatus
import java.util.*

class LocationNotFoundException(locationId: UUID) : GlobalException(
    "location: ${locationId.toString()} not found", 701, HttpStatus.NOT_FOUND
)