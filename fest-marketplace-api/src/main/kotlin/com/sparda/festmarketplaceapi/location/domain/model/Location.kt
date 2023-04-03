package com.sparda.festmarketplaceapi.location.domain.model

import com.sparda.festmarketplaceapi.fest.domain.model.Fest
import java.util.UUID

class Location(val id: UUID, val name: LocationName, val fests: MutableList<Fest> = arrayListOf()) {
}