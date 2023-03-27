package com.sparda.festmarketplaceapi.location.application.create

import com.sparda.festmarketplaceapi.shared.domain.bus.command.Command
import java.util.UUID

data class CreateLocationCommand(val id: UUID, val name: String) : Command()