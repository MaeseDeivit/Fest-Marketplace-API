package com.sparda.festmarketplaceapi.shared.domain.bus.query

import com.sparda.festmarketplaceapi.shared.application.BaseUseCase

abstract class QueryHandler(private val useCase: BaseUseCase) {
    open fun ask(query: Query) {
    }
}