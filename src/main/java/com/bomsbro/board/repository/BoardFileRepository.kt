package com.bomsbro.board.repository

import com.bomsbro.board.domain.BoardFile
import com.bomsbro.board.repository.jpa.boardFile.BoardFileReadRepository
import com.bomsbro.board.repository.jpa.boardFile.BoardFileWriteEntity
import com.bomsbro.board.repository.jpa.boardFile.BoardFileWriteEntity.toEntity
import com.bomsbro.board.repository.jpa.boardFile.BoardFileWriteRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

interface BoardFileRepository {
    fun save(boardFile: BoardFile): BoardFileWriteEntity
    fun find(boardId: Long): BoardFile

    @Repository
    open class BoardFileRdbmsRepository(
        private val boardFileWriteRepository: BoardFileWriteRepository,
        private val boardFileReadRepository: BoardFileReadRepository
    ) : BoardFileRepository {
        override fun save(boardFile: BoardFile): BoardFileWriteEntity =
            boardFileWriteRepository.save(toEntity(boardFile))

        override fun find(boardId: Long) = boardFileReadRepository.findByIdOrNull(boardId)
            ?.toDomain()
            ?: throw IllegalArgumentException("해당 게시글에 파일이 존재하지 않습니다.")
    }
}