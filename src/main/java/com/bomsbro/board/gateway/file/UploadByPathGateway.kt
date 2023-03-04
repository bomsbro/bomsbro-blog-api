package com.bomsbro.board.gateway.file

import com.bomsbro.board.domain.BoardFile
import org.springframework.stereotype.Component
import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.Files
import java.util.*
import kotlin.io.path.extension

interface UploadByPathGateway {
    fun uploadFile(boardFile: BoardFile): BoardFile

    @Component
    class UploadByPathOsGateway : UploadByPathGateway {
        override fun uploadFile(boardFile: BoardFile): BoardFile {
            val createTempFile = Files.createTempFile(boardFile.file, "${UUID.randomUUID()}", boardFile.file.extension)
            val fileChannel = FileChannel.open(createTempFile)

            ByteBuffer.allocate(1024 * 1024 * 5)
                .also { fileChannel.write(it) }
            fileChannel.close()

            return boardFile.updatePath(createTempFile)
        }
    }

}