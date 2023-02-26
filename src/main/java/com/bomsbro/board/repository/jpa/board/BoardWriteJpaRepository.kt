package com.bomsbro.board.repository.jpa.board

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BoardWriteJpaRepository: JpaRepository<BoardWriteEntity,Long> {
    fun existsByUuid(uuid: UUID): Boolean
}