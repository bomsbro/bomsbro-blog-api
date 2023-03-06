package com.bomsbro.board.domain

data class Board(
    val id: Long  = 0L,
    val title: String,
    val content: String,
    val writer: String,
    val boardStatus: BoardStatus,
) {

}
