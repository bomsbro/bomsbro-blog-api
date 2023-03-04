package com.bomsbro.board.repository

import com.bomsbro.board.domain.Board
import com.bomsbro.board.domain.BoardFile
import com.bomsbro.board.repository.jpa.board.BoardReadJpaRepository
import com.bomsbro.board.repository.jpa.board.BoardWriteEntity
import com.bomsbro.board.repository.jpa.board.BoardWriteJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

interface BoardRepository {
    fun firstInit(): Long
    fun updateBoard(board: Board): Any

    @Repository
   open class BoardRdbmsRepository(
        private val boardReadJpaRepository: BoardReadJpaRepository,
        private val boardWriteJpaRepository: BoardWriteJpaRepository
    ) : BoardRepository {
        override fun firstInit(): Long = boardWriteJpaRepository
            .save(BoardWriteEntity.first())
            .id()

        override fun updateBoard(board: Board) = boardWriteJpaRepository.findByIdOrNull(board.id)
            ?.update(board)
            ?: throw RuntimeException("Board not found")
    }
}