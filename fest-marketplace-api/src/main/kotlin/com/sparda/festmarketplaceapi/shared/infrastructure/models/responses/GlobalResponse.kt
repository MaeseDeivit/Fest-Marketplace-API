package com.sparda.festmarketplaceapi.shared.infrastructure.models.responses

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


open class GlobalResponse<T> : ResponseEntity<T> {
    constructor(body: T, status: HttpStatus?) : super(body, status!!)
}
