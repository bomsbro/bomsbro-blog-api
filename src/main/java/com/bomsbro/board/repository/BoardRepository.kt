package com.bomsbro.board.repository

import com.bomsbro.board.domain.Board
import com.bomsbro.board.repository.jpa.board.BoardReadJpaRepository
import com.bomsbro.board.repository.jpa.board.BoardWriteEntity
import com.bomsbro.board.repository.jpa.board.BoardWriteJpaRepository
import org.checkerframework.common.aliasing.qual.Unique
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

interface BoardRepository {
    fun firstInit(): Long

    @Repository
    open class BoardRdbmsRepository(
        private val boardReadJpaRepository: BoardReadJpaRepository,
        private val boardWriteJpaRepository: BoardWriteJpaRepository
    ) : BoardRepository {
        @Transactional
        override fun firstInit(): Long = boardWriteJpaRepository
            .save(BoardWriteEntity.first())
            .id()
    }
}