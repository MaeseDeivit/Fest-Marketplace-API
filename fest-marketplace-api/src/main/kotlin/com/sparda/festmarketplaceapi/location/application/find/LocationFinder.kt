package com.sparda.festmarketplaceapi.location.application.find

import com.sparda.festmarketplaceapi.location.domain.exceptions.LocationNotFoundException
import com.sparda.festmarketplaceapi.location.domain.repository.LocationRepositoryInterface
import com.sparda.festmarketplaceapi.shared.application.BaseUseCase
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.*

@Component
@Service
class LocationFinder(private val repository: LocationRepositoryInterface) : BaseUseCase() {
    fun init(id: UUID): FindLocationResponse {
        val location = repository.find(id)
        if (location === null) throw LocationNotFoundException(id)
        return FindLocationResponse(location.id.toString(), location.name.value)
    }
}