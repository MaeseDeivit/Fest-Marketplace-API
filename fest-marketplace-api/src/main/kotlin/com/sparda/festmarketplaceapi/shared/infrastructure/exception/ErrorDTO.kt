package com.sparda.festmarketplaceapi.shared.infrastructure.exception

data class ErrorDTO(private val errorMessage: String, private val errorCode: Int) {
    val result = mapOf("errorCode" to errorCode, "errorMessage" to errorMessage)
    val status = "error"
}
