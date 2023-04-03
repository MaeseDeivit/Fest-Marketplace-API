package com.sparda.festmarketplaceapi.shared.infrastructure.exception.handler

import com.sparda.festmarketplaceapi.shared.domain.exceptions.InvalidArgumentException
import com.sparda.festmarketplaceapi.shared.infrastructure.exception.ErrorDTO
import com.sparda.festmarketplaceapi.shared.infrastructure.models.responses.GlobalExceptionResponse
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*

@RestControllerAdvice
open class GlobalExceptionHandler {

    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): GlobalExceptionResponse<ErrorDTO> {
        return GlobalExceptionResponse(
            ErrorDTO(
                exception.message,
                9001,
            ), HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(value = [InvalidArgumentException::class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleInvalidArgumentException(exception: InvalidArgumentException): GlobalExceptionResponse<ErrorDTO> {
        return GlobalExceptionResponse(
            ErrorDTO(
                exception.message,
                exception.errorCode,
            ), HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(value = [HttpMessageNotReadableException::class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleHttpMessageNotReadableException(exception: HttpMessageNotReadableException): GlobalExceptionResponse<ErrorDTO> {
        return GlobalExceptionResponse(
            ErrorDTO(
                exception.message!!
            ), HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(value = [Exception::class])
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleGlobalException(exception: Exception): GlobalExceptionResponse<ErrorDTO> {
        return GlobalExceptionResponse(
            ErrorDTO(
                exception.message!!
            ), HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

}
