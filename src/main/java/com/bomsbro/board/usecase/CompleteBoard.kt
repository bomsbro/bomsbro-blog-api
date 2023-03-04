package com.bomsbro.board.usecase

import com.bomsbro.board.repository.BoardRepository

interface CompleteBoard {

    class CompleteBoardUseCase(
        private val boardRepository: BoardRepository,
    ) {
//        fun completeBoard(id: Long) = boardRepository.completeBoard(id)
    }
}