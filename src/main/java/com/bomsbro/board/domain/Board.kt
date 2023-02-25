package com.bomsbro.board.domain

import java.time.LocalDateTime
import java.util.*

data class Board(
    val uuid: UUID,
    val title: String,
    val content: String,
    val writer: String,
    val uploadDate: LocalDateTime,
    val updateDate: LocalDateTime
){
    init {

    }
}
