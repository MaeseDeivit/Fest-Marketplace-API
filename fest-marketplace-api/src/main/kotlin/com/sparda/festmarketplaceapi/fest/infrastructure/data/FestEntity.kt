package com.sparda.festmarketplaceapi.fest.infrastructure.data

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "fests")
data class FestEntity(
    @Id val id: UUID,

    @Column(unique = true, nullable = false) val name: String,

    @Column(nullable = false)
    val locationId: UUID
)