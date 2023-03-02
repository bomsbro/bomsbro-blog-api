package com.bomsbro.board.repository.jpa.board;


import com.bomsbro.board.domain.Board;
import com.bomsbro.board.domain.BoardStatus;
import com.bomsbro.global.model.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Table(name = "board")
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE board SET deleted = true WHERE id = ?")
@SQLDeleteAll(sql = "UPDATE board SET deleted = true WHERE id = ?")
@NoArgsConstructor(access = PROTECTED)
public class BoardWriteEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    private String content;
    private String writer;

    private Boolean deleted;
    @Enumerated(EnumType.STRING)
    private BoardStatus boardStatus;

    public BoardWriteEntity(
            String title,
            String content,
            String writer,
            Boolean deleted,
            BoardStatus boardStatus
    ) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.deleted = deleted;
        this.boardStatus = boardStatus;
    }

    public static BoardWriteEntity first() {
        return new BoardWriteEntity("", "", "", Boolean.FALSE, BoardStatus.PENDING);
    }

    public Long id() {
        return id;
    }

    public Board toDomain() {
        return new Board(
                this.id,
                this.title,
                this.content,
                this.writer,
                this.boardStatus
        );
    }

    public void update(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
        this.deleted = Boolean.FALSE;
        this.boardStatus = board.getBoardStatus();
    }
}
