package com.sparda.festmarketplaceapi.location.infrastructure.rest

import com.sparda.festmarketplaceapi.location.application.create.CreateLocationCommand
import com.sparda.festmarketplaceapi.location.application.create.CreateLocationCommandHandler
import com.sparda.festmarketplaceapi.location.application.create.CreateLocationResponse
import com.sparda.festmarketplaceapi.location.application.find.FindLocationQuery
import com.sparda.festmarketplaceapi.location.application.find.FindLocationQueryHandler
import com.sparda.festmarketplaceapi.location.application.find.FindLocationResponse
import com.sparda.festmarketplaceapi.location.infrastructure.models.requests.CreateLocationRequest
import com.sparda.festmarketplaceapi.shared.infrastructure.models.responses.GlobalResponse
import com.sparda.festmarketplaceapi.shared.infrastructure.rest.BaseController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["api/location"])
class LocationByIdController(private val queryHandler: FindLocationQueryHandler) :
    BaseController(queryHandler) {

    @GetMapping("/{locationId}")
    fun findLocation(
        @PathVariable("locationId") locationId: String
    ): GlobalResponse<FindLocationResponse> {
        val query = FindLocationQuery(
            UUID.fromString(locationId)
        )
        val response = queryHandler.ask(query)

        return GlobalResponse(response, HttpStatus.CREATED)
    }
}