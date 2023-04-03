package com.sparda.festmarketplaceapi.fest.domain.repository

import com.sparda.festmarketplaceapi.fest.domain.model.Fest
import java.util.*

interface FestRepositoryInterface {
    fun save(fest: Fest): Fest
    fun find(id: UUID): Fest?
}