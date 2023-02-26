package com.bomsbro.board.repository

import com.bomsbro.board.domain.Board
import com.bomsbro.board.repository.jpa.board.BoardReadJpaRepository
import com.bomsbro.board.repository.jpa.board.BoardWriteEntity
import com.bomsbro.board.repository.jpa.board.BoardWriteJpaRepository
import org.springframework.stereotype.Repository

interface BoardRepository {
    fun save(request: Board)

    @Repository
    class BoardRdbmsRepository(
        private val boardReadJpaRepository: BoardReadJpaRepository,
        private val boardWriteJpaRepository: BoardWriteJpaRepository
    ) : BoardRepository {
        override fun save(request: Board) {
            val exists = boardWriteJpaRepository.existsByUuid(request.uuid)
            require(exists){"이미 존재하는 게시글입니다."}

            boardWriteJpaRepository.save(BoardWriteEntity(request))
        }


    }
}