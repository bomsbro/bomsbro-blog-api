package com.bomsbro.board.gateway.external

import com.bomsbro.board.domain.BoardFile
import io.minio.MinioClient
import io.minio.ObjectWriteResponse
import io.minio.PutObjectArgs
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.nio.file.Path
import kotlin.io.path.inputStream


sealed interface UploadGateway {
    fun uploadFile(request: UploadRequest): ObjectWriteResponse

    @Component
    class UploadHttpGateway(
        private val minioClient: MinioClient,
        @Value("\${minio.bucket}") private val bucket: String
    ) : UploadGateway {
        override fun uploadFile(request: UploadRequest): ObjectWriteResponse = minioClient.putObject(putArgs(request));

        private fun putArgs(request: UploadRequest): PutObjectArgs = PutObjectArgs.builder()
            .bucket(bucket)
            .`object`(request.fileName)
            .stream(request.file.inputStream(), -1, BUFFER_SIZE).build()

        companion object {
            const val BUFFER_SIZE = 1024 * 1024 * 5L
        }
    }

    data class UploadRequest(
        val file: Path,
        val fileName: String
    ) {

        companion object {
            fun toRequest(file: BoardFile): UploadRequest = UploadRequest(file.file, file.fileName)
        }
    }
}

