package com.bomsbro.board.domain

import java.nio.file.Path

data class BoardFile(
    val boardId: Long,
    val fileName: String,
    val file: Path,
    val boardStatus: BoardStatus,
) {

    fun updatePath(path: Path): BoardFile = copy(file = path)
}
