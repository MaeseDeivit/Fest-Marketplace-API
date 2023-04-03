package com.sparda.festmarketplaceapi.fest.application.find

import com.sparda.festmarketplaceapi.shared.domain.bus.query.Query
import java.util.UUID

data class FindFestQuery(val id: UUID) : Query()