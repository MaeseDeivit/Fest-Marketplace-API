package com.sparda.festmarketplaceapi.fest.domain.exceptions

import com.sparda.festmarketplaceapi.shared.domain.exceptions.GlobalException
import org.springframework.http.HttpStatus
import java.util.*

class FestAlreadyExistException(festId: UUID) : GlobalException(
    "fest: ${festId.toString()} already exist", 800, HttpStatus.CONFLICT
) {}