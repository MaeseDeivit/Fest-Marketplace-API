package com.sparda.festmarketplaceapi.location.infrastructure.data

import com.sparda.festmarketplaceapi.location.domain.model.Location
import com.sparda.festmarketplaceapi.location.domain.model.LocationName
import org.springframework.stereotype.Component

@Component
class LocationDataAccessMapper {
    fun locationToLocationEntity(location: Location): LocationEntity {
        return LocationEntity(location.id, location.name.value)
    }

    fun locationEntityToLocation(locationEntity: LocationEntity): Location {
        return Location(locationEntity.id, LocationName(locationEntity.name))
    }
}