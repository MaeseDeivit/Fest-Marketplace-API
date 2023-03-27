package com.sparda.festmarketplaceapi.location.application.find

import com.sparda.festmarketplaceapi.shared.domain.bus.query.QueryHandler
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class FindLocationQueryHandler(private val useCase: LocationFinder) : QueryHandler(useCase) {

    @Transactional
    fun ask(query: FindLocationQuery): FindLocationResponse {
        useCase.validate()
        return useCase.init(
            query.id
        )
    }
}