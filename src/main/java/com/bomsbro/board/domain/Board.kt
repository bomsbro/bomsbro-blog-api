package com.bomsbro.board.domain

import java.time.LocalDateTime
import java.util.*

data class Board(
    val title: String,
    val content: String,
    val writer: String,
    val deleted: Boolean,
    val boardStatus: BoardStatus,
    val uploadDate: LocalDateTime,
    val updateDate: LocalDateTime
) {

}
