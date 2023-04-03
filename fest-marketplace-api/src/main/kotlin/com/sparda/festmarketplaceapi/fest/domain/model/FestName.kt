package com.sparda.festmarketplaceapi.fest.domain.model

import com.sparda.festmarketplaceapi.shared.domain.exceptions.InvalidArgumentException

data class FestName(val value: String) {
    init {
        validate()
    }

    private fun validate() {
        if (value.length < 3) throw InvalidArgumentException("fest name must have 3 characters or more")
        if (value.length > 40) throw InvalidArgumentException("fest name cannot have more than 60 characters")
    }
}