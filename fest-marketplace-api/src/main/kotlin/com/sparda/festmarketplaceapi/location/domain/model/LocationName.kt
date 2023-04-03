package com.sparda.festmarketplaceapi.location.domain.model

import com.sparda.festmarketplaceapi.shared.domain.exceptions.InvalidArgumentException

data class LocationName(val value: String) {
    init {
        validate()
    }

    private fun validate() {
        if (value.length < 3) throw InvalidArgumentException("location name must have 3 characters or more")
        if (value.length > 40) throw InvalidArgumentException("location name cannot have more than 40 characters")
    }
}