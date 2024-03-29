package com.sparda.festmarketplaceapi.location.infrastructure.rest

import com.sparda.festmarketplaceapi.location.application.find.FindLocationQuery
import com.sparda.festmarketplaceapi.location.application.find.FindLocationQueryHandler
import com.sparda.festmarketplaceapi.shared.infrastructure.models.responses.GlobalResponse
import com.sparda.festmarketplaceapi.shared.infrastructure.models.responses.ResponseResultSuccess
import com.sparda.festmarketplaceapi.shared.infrastructure.rest.BaseController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping(value = ["api/location"])
class LocationByIdController(private val queryHandler: FindLocationQueryHandler) :
    BaseController(queryHandler) {

    @GetMapping("/{locationId}")
    fun findLocationById(
        @PathVariable("locationId") locationId: String
    ): GlobalResponse<ResponseResultSuccess> {
        val query = FindLocationQuery(
            UUID.fromString(locationId)
        )
        return GlobalResponse(ResponseResultSuccess(queryHandler.ask(query)), HttpStatus.OK)
    }
}