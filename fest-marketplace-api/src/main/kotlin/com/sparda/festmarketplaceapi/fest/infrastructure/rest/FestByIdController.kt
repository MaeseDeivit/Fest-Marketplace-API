package com.sparda.festmarketplaceapi.fest.infrastructure.rest

import com.sparda.festmarketplaceapi.fest.application.find.FindFestQuery
import com.sparda.festmarketplaceapi.fest.application.find.FindFestQueryHandler
import com.sparda.festmarketplaceapi.shared.infrastructure.models.responses.GlobalResponse
import com.sparda.festmarketplaceapi.shared.infrastructure.models.responses.ResponseResultSuccess
import com.sparda.festmarketplaceapi.shared.infrastructure.rest.BaseController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping(value = ["api/fest"])
class FestByIdController(private val queryHandler: FindFestQueryHandler) :
    BaseController(queryHandler) {

    @GetMapping("/{festId}")
    fun findFestById(
        @PathVariable("festId") festId: String
    ): GlobalResponse<ResponseResultSuccess> {
        val query = FindFestQuery(
            UUID.fromString(festId)
        )
        return GlobalResponse(ResponseResultSuccess(queryHandler.ask(query)), HttpStatus.OK)
    }
}