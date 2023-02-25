package com.bomsbro.board.gateway.external

import io.minio.MinioClient
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.nio.file.Paths
import java.util.*

class UploadGatewayTest {
    val client = MinioClient.builder()
        .endpoint("https://s3.bomsbro.com")
        .credentials("bomsbro-blog-api", "a1a2a3a4")
        .build();

    val uploadGateway = UploadGateway.UploadHttpGateway(client, "test")

    @Test
    fun call() {
        val uploadFile = uploadGateway.uploadFile(UploadRequest(Paths.get("./test.txt"), "TEST_${UUID.randomUUID()}"))

        Assertions.assertThat(uploadFile.etag()).isNotNull()
    }
}