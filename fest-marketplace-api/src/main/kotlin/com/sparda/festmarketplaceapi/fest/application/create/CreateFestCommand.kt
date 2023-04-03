package com.sparda.festmarketplaceapi.fest.application.create

import com.sparda.festmarketplaceapi.shared.domain.bus.command.Command
import java.util.UUID

data class CreateFestCommand(val id: UUID, val name: String, val locationId: UUID) : Command()