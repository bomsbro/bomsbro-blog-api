package com.bomsbro.board.gateway.external

interface DeleteGateway {
    fun execute(fileName: String)

    class DeleteHttpGateway():D
}