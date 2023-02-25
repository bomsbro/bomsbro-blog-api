package com.bomsbro.board.repository

import com.bomsbro.board.repository.jpa.board.BoardReadJpaRepository
import com.bomsbro.board.repository.jpa.board.BoardWriteJpaRepository
import org.springframework.stereotype.Repository

interface BoardRepository {

    @Repository
    class BoardRdbmsRepository(
        private val boardReadJpaRepository: BoardReadJpaRepository,
        private val boardWriteJpaRepository: BoardWriteJpaRepository
    ) : BoardRepository {


    }
}