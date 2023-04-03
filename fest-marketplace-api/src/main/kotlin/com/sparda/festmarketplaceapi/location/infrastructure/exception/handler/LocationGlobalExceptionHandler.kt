package com.sparda.festmarketplaceapi.location.infrastructure.exception.handler

import com.sparda.festmarketplaceapi.location.domain.exceptions.LocationAlreadyExistException
import com.sparda.festmarketplaceapi.location.domain.exceptions.LocationNotFoundException
import com.sparda.festmarketplaceapi.shared.domain.exceptions.GlobalException
import com.sparda.festmarketplaceapi.shared.infrastructure.exception.ErrorDTO
import com.sparda.festmarketplaceapi.shared.infrastructure.exception.handler.GlobalExceptionHandler
import com.sparda.festmarketplaceapi.shared.infrastructure.models.responses.GlobalExceptionResponse
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.*

@ControllerAdvice
class LocationGlobalExceptionHandler : GlobalExceptionHandler() {
    @ExceptionHandler(value = [LocationAlreadyExistException::class])
    fun handleException(exception: LocationAlreadyExistException): GlobalExceptionResponse<ErrorDTO> {
        return GlobalExceptionResponse(
            ErrorDTO(
                exception.message,
                exception.errorCode,
            ), exception.httpStatus
        )
    }

    @ExceptionHandler(value = [LocationNotFoundException::class])
    fun handleException(exception: LocationNotFoundException): GlobalExceptionResponse<ErrorDTO> {
        return GlobalExceptionResponse(
            ErrorDTO(
                exception.message,
                exception.errorCode,
            ), exception.httpStatus
        )
    }
}
