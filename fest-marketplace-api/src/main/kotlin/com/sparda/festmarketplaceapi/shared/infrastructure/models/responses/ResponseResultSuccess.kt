package com.sparda.festmarketplaceapi.shared.infrastructure.models.responses

import com.sparda.festmarketplaceapi.shared.application.BaseResponse

data class ResponseResultSuccess(val result: BaseResponse) {
    val status: String = "success"
}
