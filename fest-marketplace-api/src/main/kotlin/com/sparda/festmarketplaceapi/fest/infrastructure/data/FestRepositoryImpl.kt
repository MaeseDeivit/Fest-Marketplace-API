package com.sparda.festmarketplaceapi.fest.infrastructure.data

import com.sparda.festmarketplaceapi.fest.domain.model.Fest
import com.sparda.festmarketplaceapi.fest.domain.repository.FestRepositoryInterface
import org.springframework.stereotype.Component
import java.util.*


@Component
class FestRepositoryImpl(
    private val festJpaRepository: FestJpaRepository,
    private val festDataAccessMapper: FestDataAccessMapper
) : FestRepositoryInterface {

    override fun save(fest: Fest): Fest {
        return festDataAccessMapper.festEntityToFest(
            festJpaRepository.save(
                festDataAccessMapper.festToFestEntity(
                    fest
                )
            )
        )
    }

    override fun find(id: UUID): Fest? {
        val festEntity = festJpaRepository.findById(id).orElse(null)
        if (festEntity === null) return null
        return festDataAccessMapper.festEntityToFest(festEntity)

    }
}