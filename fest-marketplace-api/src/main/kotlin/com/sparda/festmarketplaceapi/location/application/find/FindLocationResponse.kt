package com.sparda.festmarketplaceapi.location.application.find

import com.sparda.festmarketplaceapi.fest.domain.model.Fest
import com.sparda.festmarketplaceapi.shared.application.BaseResponse

data class FindLocationResponse(val id: String, val name: String, val fests: List<Fest>) : BaseResponse()