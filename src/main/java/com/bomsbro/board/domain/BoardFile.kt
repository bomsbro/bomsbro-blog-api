package com.bomsbro.board.domain

import java.nio.file.Path

data class BoardFile(
    val id: Long = 0L,
    val boardId: Long,
    val fileName: String,
    val file: Path,
    val boardStatus: BoardFileStatus = BoardFileStatus.TEMPORARY
) {

    fun updatePath(path: Path): BoardFile = copy(file = path)
    fun filePath() : String = file.toAbsolutePath().toString()
}
