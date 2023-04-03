package com.sparda.festmarketplaceapi.fest.domain.exceptions

import com.sparda.festmarketplaceapi.shared.domain.exceptions.GlobalException
import org.springframework.http.HttpStatus
import java.util.*

class FestNotFoundException(festId: UUID) : GlobalException(
    "fest: ${festId.toString()} not found", 801, HttpStatus.NOT_FOUND
) {}