package com.bomsbro.board.domain

import java.nio.file.Files
import java.nio.file.Path
import java.time.LocalDateTime

data class BoardFile(
    val uploadDate: LocalDateTime,
    val fileName: String,
    val file: Path
) {

}
