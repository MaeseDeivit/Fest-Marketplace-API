package com.sparda.festmarketplaceapi.location.application.create

import com.sparda.festmarketplaceapi.location.domain.exceptions.LocationAlreadyExistException
import com.sparda.festmarketplaceapi.location.domain.model.Location
import com.sparda.festmarketplaceapi.location.domain.model.LocationName
import com.sparda.festmarketplaceapi.location.domain.repository.LocationRepositoryInterface
import com.sparda.festmarketplaceapi.shared.application.BaseUseCase
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.*

@Component
@Service
class LocationCreator(private val repository: LocationRepositoryInterface) : BaseUseCase() {
    fun init(id: UUID, name: String): CreateLocationResponse {
        if (repository.find(id) !== null) throw LocationAlreadyExistException(id)
        val location: Location = repository.save(Location(id, LocationName(name)))
        return CreateLocationResponse(location.id.toString(), location.name.value, location.fests)
    }
}