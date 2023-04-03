package com.sparda.festmarketplaceapi.fest.application.find

import com.sparda.festmarketplaceapi.fest.domain.exceptions.FestNotFoundException
import com.sparda.festmarketplaceapi.fest.domain.repository.FestRepositoryInterface
import com.sparda.festmarketplaceapi.shared.application.BaseUseCase
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.*

@Component
@Service
class FestFinder(private val repository: FestRepositoryInterface) : BaseUseCase() {
    fun init(id: UUID): FindFestResponse {
        val fest = repository.find(id)
        if (fest === null) throw FestNotFoundException(id)
        return FindFestResponse(
            fest.id.toString(),
            fest.name.value,
            fest.locationId.toString()
        )
    }
}