package com.bomsbro.board.repository

import com.bomsbro.board.domain.BoardFile
import com.bomsbro.board.domain.BoardFileStatus
import com.bomsbro.board.repository.jpa.board.BoardReadJpaRepository
import com.bomsbro.board.repository.jpa.board.BoardWriteEntity
import com.bomsbro.board.repository.jpa.board.BoardWriteJpaRepository
import com.bomsbro.board.repository.jpa.boardFile.BoardFileReadRepository
import com.bomsbro.board.repository.jpa.boardFile.BoardFileWriteRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional
import java.nio.file.Paths

@DataJpaTest
@Transactional
@ActiveProfiles("dev")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
open class BoardFileRepositoryTest{
    @Autowired
    lateinit var write: BoardWriteJpaRepository
    @Autowired
    lateinit var boardFileReadRepository: BoardFileReadRepository
    @Autowired
    lateinit var boardFileWriteRepository: BoardFileWriteRepository

    lateinit var boardFileRepository: BoardFileRepository

    @BeforeEach
    fun init(){
        boardFileRepository = BoardFileRepository.BoardFileRdbmsRepository(boardFileWriteRepository, boardFileReadRepository)

        val save = write.save(BoardWriteEntity.first())

    }


    @Test
    fun firstInitTest(){
        val save = boardFileRepository.save(BoardFile(boardId = 1L, fileName = "test",file= Paths.get("src/main/resources/logback-spring.xml")))
        println("save = ${save.boardId}")
    }
}