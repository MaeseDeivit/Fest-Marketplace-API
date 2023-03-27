package com.sparda.festmarketplaceapi.shared.infrastructure.models.responses

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap


open class GlobalResponse<T> : ResponseEntity<T> {
    constructor(status: HttpStatus?) : super(status!!)
    constructor(body: T, status: HttpStatus?) : super(body, status!!)
    constructor(headers: MultiValueMap<String?, String?>?, status: HttpStatus?) : super(
        headers!!,
        status!!
    )

    constructor(body: T, headers: MultiValueMap<String?, String?>?, status: HttpStatus?) : super(
        body, headers,
        status!!
    )

    constructor(body: T, headers: MultiValueMap<String?, String?>?, rawStatus: Int) : super(body, headers, rawStatus)
}
