package com.bomsbro.board.gateway.external

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

sealed interface UploadGateway{
    fun uploadFile()

    @Component
    class UploadHttpGateway(
        private val webClient: WebClient
    ):UploadGateway{
        override fun uploadFile() {
            TODO("Not yet implemented")
        }

    }
}
