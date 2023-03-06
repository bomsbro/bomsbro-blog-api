package com.bomsbro.board.repository.jpa.boardFile

import com.bomsbro.board.domain.BoardFile
import org.springframework.data.jpa.repository.JpaRepository

interface BoardFileWriteRepository : JpaRepository<BoardFileWriteEntity, Long>