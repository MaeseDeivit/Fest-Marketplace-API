package com.sparda.festmarketplaceapi.location.infrastructure.rest

import com.sparda.festmarketplaceapi.location.application.create.CreateLocationCommand
import com.sparda.festmarketplaceapi.location.application.create.CreateLocationCommandHandler
import com.sparda.festmarketplaceapi.location.application.create.CreateLocationResponse
import com.sparda.festmarketplaceapi.location.application.find.FindLocationQuery
import com.sparda.festmarketplaceapi.location.application.find.FindLocationResponse
import com.sparda.festmarketplaceapi.location.infrastructure.models.requests.CreateLocationRequest
import com.sparda.festmarketplaceapi.shared.infrastructure.models.responses.GlobalResponse
import com.sparda.festmarketplaceapi.shared.infrastructure.rest.BaseController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["api/location"])
class LocationPostController(private val commandHandler: CreateLocationCommandHandler) :
    BaseController(commandHandler) {

    @PostMapping("/{locationId}")
    fun createLocation(
        @PathVariable("locationId") locationId: String, @RequestBody request: CreateLocationRequest
    ): GlobalResponse<CreateLocationResponse> {
        val command = CreateLocationCommand(
            UUID.fromString(locationId), "Barcelona"
        )
        val response = commandHandler.dispatch(command)

        return GlobalResponse(response, HttpStatus.CREATED)
    }

    @GetMapping("/check")
    fun checkRoute() = run {
        "CheckRoute"
    }
}