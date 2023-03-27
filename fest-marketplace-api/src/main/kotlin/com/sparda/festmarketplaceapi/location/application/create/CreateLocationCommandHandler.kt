package com.sparda.festmarketplaceapi.location.application.create

import com.sparda.festmarketplaceapi.shared.domain.bus.query.QueryHandler
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CreateLocationCommandHandler(private val useCase: LocationCreator) : QueryHandler(useCase) {

    @Transactional
    fun dispatch(command: CreateLocationCommand): CreateLocationResponse {
        useCase.validate()
        return useCase.init(
            command.id, command.name
        )
    }
}