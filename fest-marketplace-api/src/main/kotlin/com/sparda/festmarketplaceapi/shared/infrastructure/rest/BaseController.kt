package com.sparda.festmarketplaceapi.shared.infrastructure.rest

import com.sparda.festmarketplaceapi.shared.domain.bus.query.QueryHandler

abstract class BaseController (private val commandHandler: QueryHandler){
}