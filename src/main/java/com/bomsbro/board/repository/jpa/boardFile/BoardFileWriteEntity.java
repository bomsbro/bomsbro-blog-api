package com.bomsbro.board.repository.jpa.boardFile;

import com.bomsbro.board.domain.BoardFile;
import com.bomsbro.board.domain.BoardFileStatus;
import com.bomsbro.board.domain.BoardStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.nio.file.Path;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Table(name = "board_file")
@NoArgsConstructor(access = PROTECTED)
public class BoardFileWriteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String filePath;
    private Long boardId;

    @Enumerated(EnumType.STRING)
    private BoardFileStatus status;

    private BoardFileWriteEntity(String fileName, String filePath, Long boardId, BoardFileStatus status) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.boardId = boardId;
        this.status = status;
    }


    public static BoardFileWriteEntity toEntity(BoardFile boardFile) {
        return new BoardFileWriteEntity(boardFile.getFileName(), boardFile.filePath(), boardFile.getBoardId(),boardFile.getBoardStatus());
    }
}
