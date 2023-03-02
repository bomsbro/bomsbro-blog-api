package com.bomsbro.board.domain

import java.nio.file.Path
import java.time.LocalDateTime

data class BoardFile(
    val fileName: String,
    val file: Path,
    val boardStatus: BoardStatus,
    val uploadDate: LocalDateTime,
    val updateDate: LocalDateTime
) {

}
