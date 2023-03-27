package com.sparda.festmarketplaceapi.location.infrastructure.exception.handler

import com.sparda.festmarketplaceapi.location.domain.exceptions.LocationAlreadyExistException
import com.sparda.festmarketplaceapi.location.domain.exceptions.LocationNotFoundException
import com.sparda.festmarketplaceapi.shared.infrastructure.exception.ErrorDTO
import com.sparda.festmarketplaceapi.shared.infrastructure.exception.handler.GlobalExceptionHandler
import com.sparda.festmarketplaceapi.shared.infrastructure.models.responses.GlobalExceptionResponse
import org.springframework.web.bind.annotation.*

@ControllerAdvice
class LocationGlobalExceptionHandler : GlobalExceptionHandler() {
    @ExceptionHandler(value = [LocationAlreadyExistException::class])
    fun handleException(locationAlreadyExistException: LocationAlreadyExistException): GlobalExceptionResponse<ErrorDTO> {
        return GlobalExceptionResponse(
            ErrorDTO(
                locationAlreadyExistException.message,
                locationAlreadyExistException.errorCode,
            ), locationAlreadyExistException.httpStatus
        )
    }


    @ExceptionHandler(value = [LocationNotFoundException::class])
    fun handleException(locationNotFoundException: LocationNotFoundException): GlobalExceptionResponse<ErrorDTO> {
        return GlobalExceptionResponse(
            ErrorDTO(
                locationNotFoundException.message,
                locationNotFoundException.errorCode,
            ), locationNotFoundException.httpStatus
        )
    }
}
