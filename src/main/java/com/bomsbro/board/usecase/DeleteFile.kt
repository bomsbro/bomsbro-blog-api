package com.bomsbro.board.usecase

import com.bomsbro.board.domain.BoardFile
import com.bomsbro.board.domain.BoardFileStatus
import com.bomsbro.board.gateway.external.UploadGateway
import com.bomsbro.board.repository.BoardFileRepository

interface DeleteFile {

    class DeleteFileUseCase(
        private val uploadGateway: UploadGateway,
        private val boardFileRepository: BoardFileRepository
    ) : DeleteFile {
        fun execute(boardFile: BoardFile) {
            when (boardFileRepository.find(boardFile.boardId).boardStatus) {
                BoardFileStatus.TEMPORARY -> uploadGateway.deleteImage(boardFile.fileName)
                BoardFileStatus.UPLOADED -> uploadGateway.deleteVideo(boardFile.fileName)
            }
        }
    }
}