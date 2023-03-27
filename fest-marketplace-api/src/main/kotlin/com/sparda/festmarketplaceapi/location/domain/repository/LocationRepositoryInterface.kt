package com.sparda.festmarketplaceapi.location.domain.repository

import com.sparda.festmarketplaceapi.location.domain.model.Location
import java.util.*

interface LocationRepositoryInterface {
    fun save(location: Location)
    fun find(id: UUID): Location?
}