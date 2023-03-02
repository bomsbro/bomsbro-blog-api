package com.bomsbro.board.domain

import java.time.LocalDateTime
import java.util.*

data class Board(
    val id: Long,
    val title: String,
    val content: String,
    val writer: String,
    val boardStatus: BoardStatus,
) {

}
