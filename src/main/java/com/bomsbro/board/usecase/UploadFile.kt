package com.bomsbro.board.usecase

import com.bomsbro.board.domain.BoardFile
import com.bomsbro.board.gateway.external.UploadGateway
import com.bomsbro.board.gateway.file.UploadByPathGateway
import com.bomsbro.board.repository.BoardFileRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface UploadFile {

    @Service
    @Transactional
    open class UploadFileUseCase(
        private val gateway: UploadByPathGateway,
        private val repository: BoardFileRepository
    ): UploadFile{

        fun execute(boardFile: BoardFile) {
            gateway.uploadFile(boardFile)
            repository.save(boardFile)
        }

    }
}