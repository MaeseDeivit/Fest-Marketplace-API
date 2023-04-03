package com.sparda.festmarketplaceapi.fest.infrastructure.exception.handler

import com.sparda.festmarketplaceapi.fest.domain.exceptions.FestAlreadyExistException
import com.sparda.festmarketplaceapi.fest.domain.exceptions.FestNotFoundException
import com.sparda.festmarketplaceapi.shared.infrastructure.exception.ErrorDTO
import com.sparda.festmarketplaceapi.shared.infrastructure.exception.handler.GlobalExceptionHandler
import com.sparda.festmarketplaceapi.shared.infrastructure.models.responses.GlobalExceptionResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class FestGlobalExceptionHandler : GlobalExceptionHandler() {
    @ExceptionHandler(value = [FestAlreadyExistException::class])
    fun handleException(exception: FestAlreadyExistException): GlobalExceptionResponse<ErrorDTO> {
        return GlobalExceptionResponse(
            ErrorDTO(
                exception.message,
                exception.errorCode,
            ), exception.httpStatus
        )
    }

    @ExceptionHandler(value = [FestNotFoundException::class])
    fun handleException(exception: FestNotFoundException): GlobalExceptionResponse<ErrorDTO> {
        return GlobalExceptionResponse(
            ErrorDTO(
                exception.message,
                exception.errorCode,
            ), exception.httpStatus
        )
    }
}
