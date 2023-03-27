package com.sparda.festmarketplaceapi.location.application.find

import com.sparda.festmarketplaceapi.shared.application.BaseResponse

data class FindLocationResponse(private val id: String, private val name: String) : BaseResponse() {
}