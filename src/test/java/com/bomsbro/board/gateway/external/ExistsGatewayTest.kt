package com.bomsbro.board.gateway.external

import com.bomsbro.board.gateway.external.MinioFixture.Companion.BUCKET
import com.bomsbro.board.gateway.external.MinioFixture.Companion.CLIENT
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ExistsGatewayTest{
    val existsGateway = ExistsGateway.ExistsHttpGateway(CLIENT, BUCKET)

    @Test
    fun call(){
        val exists = existsGateway.findBy("test.txt")
        assertTrue(exists)
    }
}