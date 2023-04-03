package com.sparda.festmarketplaceapi.fest.infrastructure.rest

import com.sparda.festmarketplaceapi.fest.application.create.CreateFestCommand
import com.sparda.festmarketplaceapi.fest.application.create.CreateFestCommandHandler
import com.sparda.festmarketplaceapi.fest.infrastructure.models.requests.CreateFestRequest
import com.sparda.festmarketplaceapi.shared.infrastructure.models.responses.GlobalResponse
import com.sparda.festmarketplaceapi.shared.infrastructure.models.responses.ResponseResultSuccess
import com.sparda.festmarketplaceapi.shared.infrastructure.rest.BaseController
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["api/fest"])
class FestPostController(private val commandHandler: CreateFestCommandHandler) :
    BaseController(commandHandler) {

    @PostMapping("/{festId}")
    fun createLocation(
        @PathVariable("festId") festId: String, @Valid @RequestBody request: CreateFestRequest
    ): GlobalResponse<ResponseResultSuccess> {
        val command = CreateFestCommand(
            UUID.fromString(festId), request.festName, request.locationId
        )
        return GlobalResponse(ResponseResultSuccess(commandHandler.dispatch(command)), HttpStatus.CREATED)
    }
}