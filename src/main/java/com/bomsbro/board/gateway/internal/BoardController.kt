package com.bomsbro.board.gateway.internal

import com.bomsbro.board.domain.BoardFile
import com.bomsbro.board.domain.BoardFileStatus
import com.bomsbro.board.domain.BoardStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

@RestController
@RequestMapping("/board")
class BoardController {

    @PostMapping("/test")
    fun test(request: BoardFile) {
        println("test")
    }

    data class BoardFileRequest(
        val boardId: Long,
        val fileName: String,
        val file: MultipartFile,
    ) {
        fun toDomain(): BoardFile {
            val path =  Files.createTempFile("${UUID.randomUUID()}_",file.name)
                .also { file.transferTo(it) }
            return BoardFile(boardId = boardId, fileName = fileName, file = path)
        }
    }
}