package com.sparda.festmarketplaceapi.fest.application.create

import com.sparda.festmarketplaceapi.fest.domain.exceptions.FestAlreadyExistException
import com.sparda.festmarketplaceapi.fest.domain.model.Fest
import com.sparda.festmarketplaceapi.fest.domain.model.FestName
import com.sparda.festmarketplaceapi.fest.domain.repository.FestRepositoryInterface
import com.sparda.festmarketplaceapi.location.domain.exceptions.LocationNotFoundException
import com.sparda.festmarketplaceapi.location.domain.repository.LocationRepositoryInterface
import com.sparda.festmarketplaceapi.shared.application.BaseUseCase
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.*

@Component
@Service
class FestCreator(
    private val repository: FestRepositoryInterface,
    private val repositoryLocation: LocationRepositoryInterface
) : BaseUseCase() {
    fun init(id: UUID, name: String, locationId: UUID): CreateFestResponse {
        if (repository.find(id) !== null) throw FestAlreadyExistException(id)
        if (repositoryLocation.find(locationId) === null) throw LocationNotFoundException(locationId)
        val fest = repository.save(Fest(id, FestName(name), locationId))
        return CreateFestResponse(fest.id.toString(), fest.name.value, fest.locationId.toString())
    }
}