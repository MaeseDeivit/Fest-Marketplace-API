package com.sparda.festmarketplaceapi.location.application.find

import com.sparda.festmarketplaceapi.shared.domain.bus.query.Query
import java.util.UUID

data class FindLocationQuery(val id: UUID) : Query()