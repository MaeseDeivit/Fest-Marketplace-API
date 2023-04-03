package com.sparda.festmarketplaceapi.fest.application.create

import com.sparda.festmarketplaceapi.shared.application.BaseResponse

data class CreateFestResponse(val id: String, val name: String, val locationId: String) : BaseResponse()