package com.sparda.festmarketplaceapi.location.domain.exceptions

import com.sparda.festmarketplaceapi.shared.domain.exceptions.GlobalException
import org.springframework.http.HttpStatus
import java.util.*

class LocationAlreadyExistException(locationId: UUID) : GlobalException(
    "location: ${locationId.toString()} already exist", 700, HttpStatus.CONFLICT
) {}