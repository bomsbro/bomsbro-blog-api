package com.bomsbro.board.gateway.external

import com.bomsbro.board.domain.BoardFile
import com.bomsbro.board.gateway.external.MinioFixture.Companion.BUCKET
import com.bomsbro.board.gateway.external.MinioFixture.Companion.CLIENT
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class UploadGatewayTest {
    val uploadGateway = UploadGateway.UploadHttpGateway(CLIENT, BUCKET)

    @Test
    fun call() {
        val uploadFile = uploadGateway.uploadFile(
            BoardFile(
                boardId = 1L,
                fileName = "test",
                file = Paths.get("src/main/resources/logback-spring.xml")
            )
        )
        Assertions.assertThat(uploadFile.etag()).isNotNull()
    }
}