package com.bomsbro.board.domain

import java.nio.file.Files
import java.time.LocalDateTime

data class File(
    private val uploadDate:LocalDateTime,
    private val fileName:String,
    private val file:Files
)
