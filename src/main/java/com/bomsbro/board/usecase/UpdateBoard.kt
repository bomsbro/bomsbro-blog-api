package com.bomsbro.board.usecase

import com.bomsbro.board.domain.Board
import com.bomsbro.board.repository.BoardRepository
import org.springframework.stereotype.Component

interface UpdateBoard {

    @Component
    class UpdateUseCase(
        private val boardRepository: BoardRepository,
    ) {
        fun updateBoard(board: Board) = boardRepository.updateBoard(board)
    }
}