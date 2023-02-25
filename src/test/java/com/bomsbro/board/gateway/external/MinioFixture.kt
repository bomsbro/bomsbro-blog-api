package com.bomsbro.board.gateway.external

import io.minio.MinioClient

class MinioFixture {
    companion object {
        const val BUCKET = "test"
        val CLIENT = MinioClient.builder()
            .endpoint("https://s3.bomsbro.com")
            .credentials("bomsbro-blog-api", "a1a2a3a4")
            .build();
    }
}