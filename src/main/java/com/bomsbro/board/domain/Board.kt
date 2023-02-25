package com.bomsbro.board.domain

import java.util.*

data class Board(
    private val uuid: UUID,
    private val title:String,
    private val content:String,
    private val writer:String,
    private val uploadDate:String,
    private val updateDate:String
)
