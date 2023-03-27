package com.sparda.festmarketplaceapi.shared.domain.bus.command

import com.sparda.festmarketplaceapi.shared.application.BaseUseCase

abstract class CommandHandler(private val useCase: BaseUseCase) {
    open fun dispatch(command: Command) {
    }
}