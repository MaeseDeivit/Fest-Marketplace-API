package com.sparda.festmarketplaceapi.fest.infrastructure.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FestJpaRepository : JpaRepository<FestEntity, UUID> {
    fun findByLocationId(locationId: UUID): List<FestEntity?>?

}
