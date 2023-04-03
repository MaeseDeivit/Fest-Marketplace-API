package com.sparda.festmarketplaceapi.fest.application.find

import com.sparda.festmarketplaceapi.shared.application.BaseResponse

data class FindFestResponse(val id: String, val name: String, val locationId: String) : BaseResponse()