package com.bomsbro.board.usecase

import com.bomsbro.board.gateway.external.ExistsGateway
import com.bomsbro.board.gateway.external.UploadGateway
import com.bomsbro.board.repository.BoardRepository
import org.springframework.stereotype.Service

interface InitBoard {
    fun firstInit(): Long

    @Service
    class InitBoardUseCase(
        private val boardRepository: BoardRepository,
    ) : InitBoard {
        override fun firstInit() = boardRepository.firstInit()
    }

}