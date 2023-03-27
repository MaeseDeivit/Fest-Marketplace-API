package com.sparda.festmarketplaceapi.shared.domain.exceptions

import org.springframework.http.HttpStatus

abstract class GlobalException(override val message: String, open val errorCode: Int, open val httpStatus: HttpStatus) : Exception(message) {
}