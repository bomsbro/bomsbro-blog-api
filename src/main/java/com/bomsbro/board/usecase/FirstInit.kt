package com.bomsbro.board.usecase

import com.bomsbro.board.gateway.external.ExistsGateway
import com.bomsbro.board.gateway.external.UploadGateway
import com.bomsbro.board.repository.BoardRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

interface FirstInit {
    fun firstInit(): Long

    @Service
    class FirstInitUseCase(
        private val boardRepository: BoardRepository,
        private val existsGateway: ExistsGateway,
        private val uploadGateway: UploadGateway
    ) : FirstInit {
        override fun firstInit() = boardRepository.firstInit()
    }

}