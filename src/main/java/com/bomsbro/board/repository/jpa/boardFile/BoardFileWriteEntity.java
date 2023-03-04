package com.bomsbro.board.repository.jpa.boardFile;

import com.bomsbro.board.domain.BoardFileStatus;
import com.bomsbro.board.domain.BoardStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

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
    private BoardStatus boardStatus;
    private String fileName;
    private String filePath;
    private String fileDownloadUri;
    private Long boardId;

    @Enumerated(EnumType.STRING)
    private BoardFileStatus status;
}
