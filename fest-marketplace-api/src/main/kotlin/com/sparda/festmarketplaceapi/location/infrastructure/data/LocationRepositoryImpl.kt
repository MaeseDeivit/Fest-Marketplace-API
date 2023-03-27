package com.sparda.festmarketplaceapi.location.infrastructure.data

import com.sparda.festmarketplaceapi.location.domain.model.Location
import com.sparda.festmarketplaceapi.location.domain.repository.LocationRepositoryInterface
import org.springframework.data.jpa.domain.AbstractPersistable_
import org.springframework.stereotype.Component
import java.util.*


@Component
class LocationRepositoryImpl(
    private val locationJpaRepository: LocationJpaRepository,
    private val locationDataAccessMapper: LocationDataAccessMapper
) : LocationRepositoryInterface {

    override fun save(location: Location) {
        this.locationJpaRepository.save(locationDataAccessMapper.locationToLocationEntity(location))
    }

    override fun find(id: UUID): Location? {
        val locationEntity = locationJpaRepository.findById(id).orElse(null)
        if (locationEntity === null) return null
        return locationDataAccessMapper.locationEntityToLocation(locationEntity)

    }
}