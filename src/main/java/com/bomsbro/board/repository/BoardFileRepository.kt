package com.bomsbro.board.repository

import com.bomsbro.board.domain.BoardFile
import com.bomsbro.board.repository.jpa.boardFile.BoardFileReadRepository
import com.bomsbro.board.repository.jpa.boardFile.BoardFileWriteRepository
import org.springframework.stereotype.Repository

interface BoardFileRepository {
    fun save(boardFile: BoardFile)

    @Repository
    open class BoardFileRdbmsRepository(
        private val boardFileWriteRepository: BoardFileWriteRepository,
        private val boardFileReadRepository: BoardFileReadRepository
    ) : BoardFileRepository{
        override fun save(boardFile: BoardFile) {

        }

    }
}