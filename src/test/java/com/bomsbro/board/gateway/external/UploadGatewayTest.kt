package com.bomsbro.board.gateway.external

import com.bomsbro.board.gateway.external.MinioFixture.Companion.BUCKET
import com.bomsbro.board.gateway.external.MinioFixture.Companion.CLIENT
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.nio.file.Paths
import java.util.*

class UploadGatewayTest {
    val uploadGateway = UploadGateway.UploadHttpGateway(CLIENT, BUCKET)

    @Test
    fun call() {
        val uploadFile = uploadGateway.uploadFile(
            UploadGateway.UploadRequest(
                Paths.get("./test.txt"),
                "TEST_${UUID.randomUUID()}"
            )
        )

        Assertions.assertThat(uploadFile.etag()).isNotNull()
    }
}