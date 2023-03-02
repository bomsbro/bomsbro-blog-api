package com.bomsbro.board.repository

import com.bomsbro.board.repository.jpa.board.BoardReadJpaRepository
import com.bomsbro.board.repository.jpa.board.BoardWriteJpaRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional

@DataJpaTest
@Transactional
@ActiveProfiles("dev")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
open class BoardRepositoryTest{
    @Autowired
    lateinit var write: BoardWriteJpaRepository
    @Autowired
    lateinit var read: BoardReadJpaRepository


    lateinit var boardRepository: BoardRepository
    @BeforeEach
    fun setUp() {
        boardRepository = BoardRepository.BoardRdbmsRepository(read,write)
    }

    @Test
    fun firstInitTest(){
        assertDoesNotThrow {
            val uuid = boardRepository.firstInit()
            Assertions.assertNotNull(uuid)
        }
    }

}