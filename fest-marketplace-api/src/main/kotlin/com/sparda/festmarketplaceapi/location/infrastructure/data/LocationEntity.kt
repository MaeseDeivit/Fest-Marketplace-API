package com.sparda.festmarketplaceapi.location.infrastructure.data

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "locations")
data class LocationEntity(
    @Id val id: UUID,

    @Column(unique = true, nullable = false)
    val name: String
)