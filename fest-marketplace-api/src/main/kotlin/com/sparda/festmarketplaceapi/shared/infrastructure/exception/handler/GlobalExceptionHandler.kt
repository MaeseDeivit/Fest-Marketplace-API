package com.sparda.festmarketplaceapi.shared.infrastructure.exception.handler

import com.sparda.festmarketplaceapi.shared.domain.exceptions.GlobalException
import com.sparda.festmarketplaceapi.shared.infrastructure.exception.ErrorDTO
import com.sparda.festmarketplaceapi.shared.infrastructure.models.responses.GlobalExceptionResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestControllerAdvice
open class GlobalExceptionHandler {
    @ExceptionHandler(value = [Exception::class])
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handlerException(exception: GlobalException): GlobalExceptionResponse<ErrorDTO> {
        return GlobalExceptionResponse(
            ErrorDTO(
                exception.message,
                exception.errorCode,
            ), exception.httpStatus
        )
    }

}
