package com.bomsbro.board.repository.jpa.board

import org.springframework.data.jpa.repository.JpaRepository

interface BoardReadJpaRepository : JpaRepository<BoardReadEntity, Long> {
}