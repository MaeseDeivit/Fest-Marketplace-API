package com.sparda.festmarketplaceapi.fest.application.create

import com.sparda.festmarketplaceapi.shared.domain.bus.query.QueryHandler
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CreateFestCommandHandler(private val useCase: FestCreator) : QueryHandler(useCase) {

    @Transactional
    fun dispatch(command: CreateFestCommand): CreateFestResponse {
        useCase.validate()
        return useCase.init(
            command.id, command.name, command.locationId
        )
    }
}