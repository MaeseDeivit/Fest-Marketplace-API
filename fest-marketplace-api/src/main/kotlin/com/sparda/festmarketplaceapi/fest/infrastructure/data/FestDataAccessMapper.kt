package com.sparda.festmarketplaceapi.fest.infrastructure.data

import com.sparda.festmarketplaceapi.fest.domain.model.Fest
import com.sparda.festmarketplaceapi.fest.domain.model.FestName
import com.sparda.festmarketplaceapi.location.domain.model.Location
import com.sparda.festmarketplaceapi.location.domain.model.LocationName
import com.sparda.festmarketplaceapi.location.infrastructure.data.LocationEntity
import org.springframework.stereotype.Component

@Component
class FestDataAccessMapper {
    fun festToFestEntity(fest: Fest): FestEntity {
        return FestEntity(fest.id, fest.name.value, fest.locationId)
    }

    fun festEntityToFest(festEntity: FestEntity): Fest {
        return Fest(
            festEntity.id,
            FestName(festEntity.name),
            festEntity.locationId
        )
    }

    fun festsToFestEntities(fests: MutableList<Fest>): MutableList<FestEntity> {
        return fests.map {
            FestEntity(
                it.id,
                it.name.value,
                it.locationId
            )
        }.toMutableList()
    }
}