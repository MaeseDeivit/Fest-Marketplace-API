package com.sparda.festmarketplaceapi.location.infrastructure.data

import com.sparda.festmarketplaceapi.fest.domain.model.Fest
import com.sparda.festmarketplaceapi.fest.domain.model.FestName
import com.sparda.festmarketplaceapi.fest.infrastructure.data.FestEntity
import com.sparda.festmarketplaceapi.location.domain.model.Location
import com.sparda.festmarketplaceapi.location.domain.model.LocationName
import org.springframework.stereotype.Component

@Component
class LocationDataAccessMapper {
    fun locationToLocationEntity(location: Location): LocationEntity {
        return LocationEntity(
            location.id,
            location.name.value
        )
    }


    fun locationEntityToLocation(locationEntity: LocationEntity, festEntities: List<FestEntity?>?): Location {
        return Location(
            locationEntity.id,
            LocationName(locationEntity.name),
            festsEntitiesToFests(festEntities)
        )
    }

    private fun festsEntitiesToFests(festsEntities: List<FestEntity?>?): MutableList<Fest> {
        if (festsEntities === null) return arrayListOf()
        return festsEntities.map {
            Fest(
                it!!.id,
                FestName(it.name),
                it.locationId
            )
        }.toMutableList()
    }
}