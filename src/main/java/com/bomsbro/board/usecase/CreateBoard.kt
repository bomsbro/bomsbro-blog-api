package com.bomsbro.board.usecase

import com.bomsbro.board.domain.Board
import com.bomsbro.board.gateway.external.ExistsGateway
import com.bomsbro.board.gateway.external.UploadGateway
import com.bomsbro.board.repository.BoardRepository
import org.springframework.stereotype.Component

interface CreateBoard {
    fun create(request: Board): Any

    @Component
    class CreateBoarUseCase(
        private val boardRepository: BoardRepository,
        private val existsGateway: ExistsGateway,
        private val uploadGateway: UploadGateway
    ) : CreateBoard {
        override fun create(request: Board) {
            boardRepository.save(request)
        }
    }

}