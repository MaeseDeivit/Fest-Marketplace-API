package com.sparda.festmarketplaceapi.location.infrastructure.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LocationJpaRepository : JpaRepository<LocationEntity, UUID>