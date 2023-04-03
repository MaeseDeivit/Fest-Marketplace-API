package com.sparda.festmarketplaceapi.fest.application.find

import com.sparda.festmarketplaceapi.shared.domain.bus.query.QueryHandler
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class FindFestQueryHandler(private val useCase: FestFinder) : QueryHandler(useCase) {

    @Transactional
    fun ask(query: FindFestQuery): FindFestResponse {
        useCase.validate()
        return useCase.init(
            query.id
        )
    }
}