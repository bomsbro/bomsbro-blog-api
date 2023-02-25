package com.bomsbro.board.repository.jpa.board

import org.springframework.data.jpa.repository.JpaRepository

interface BoardWriteJpaRepository: JpaRepository<BoardWriteEntity,Long> {
}