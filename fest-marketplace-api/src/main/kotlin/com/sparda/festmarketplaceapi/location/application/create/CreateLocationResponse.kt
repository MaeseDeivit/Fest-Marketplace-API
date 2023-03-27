package com.sparda.festmarketplaceapi.location.application.create

import com.sparda.festmarketplaceapi.shared.application.BaseResponse

data class CreateLocationResponse(val id: String, val name: String) : BaseResponse() {
}