package com.sparda.festmarketplaceapi.shared.domain.exceptions

import org.springframework.http.HttpStatus

class InvalidArgumentException(message: String) : GlobalException(
    message, 9001, HttpStatus.BAD_REQUEST
) {}