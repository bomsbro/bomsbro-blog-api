package com.bomsbro.board.gateway.external

import io.minio.BucketExistsArgs
import io.minio.MinioClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

sealed interface ExistsGateway {
    fun findBy(fileName: String): Boolean

    @Component
    class ExistsHttpGateway(
        private val minioClient: MinioClient,
        @Value("\${minio.bucket}") private val bucket: String
    ) : ExistsGateway {
        override fun findBy(fileName: String): Boolean = minioClient.bucketExists(bucketExistsArgs());

        private fun bucketExistsArgs(): BucketExistsArgs = BucketExistsArgs.builder().bucket(bucket).build()
    }

}