package com.sparda.festmarketplaceapi.location.infrastructure.data

import com.sparda.festmarketplaceapi.fest.infrastructure.data.FestDataAccessMapper
import com.sparda.festmarketplaceapi.fest.infrastructure.data.FestJpaRepository
import com.sparda.festmarketplaceapi.location.domain.model.Location
import com.sparda.festmarketplaceapi.location.domain.repository.LocationRepositoryInterface
import org.springframework.stereotype.Component
import java.util.*


@Component
class LocationRepositoryImpl(
    private val locationJpaRepository: LocationJpaRepository,
    private val festsJpaRepository: FestJpaRepository,
    private val locationDataAccessMapper: LocationDataAccessMapper,
    private val festDataAccessMapper: FestDataAccessMapper
) : LocationRepositoryInterface {

    override fun save(location: Location): Location {
        val festEntities = if (location.fests.isNotEmpty()) festsJpaRepository.saveAll(
            festDataAccessMapper.festsToFestEntities(location.fests)
        ) else null

        return locationDataAccessMapper.locationEntityToLocation(
            locationJpaRepository.save(
                locationDataAccessMapper.locationToLocationEntity(location)
            ), festEntities
        )
    }

    override fun find(id: UUID): Location? {
        val locationEntity = locationJpaRepository.findById(id).orElse(null)
        if (locationEntity === null) return null
        val festEntities = festsJpaRepository.findByLocationId(locationEntity.id)
        return locationDataAccessMapper.locationEntityToLocation(locationEntity, festEntities)

    }
}