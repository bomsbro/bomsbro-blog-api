package com.bomsbro.board.repository.jpa.board;


import com.bomsbro.board.domain.Board;
import com.bomsbro.global.model.entity.BaseTimeEntity;
import lombok.NoArgsConstructor;
import org.checkerframework.common.aliasing.qual.Unique;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "board")
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE board SET deleted = true WHERE id = ?")
@SQLDeleteAll(sql = "UPDATE board SET deleted = true WHERE id = ?")
@NoArgsConstructor(access = PROTECTED)
public class BoardWriteEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Unique
    private UUID uuid;
    private String title;
    @Lob
    private String content;
    private String writer;


    public BoardWriteEntity(Board board) {
        this.uuid = board.getUuid();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
        super.createdDate = board.getUploadDate();
        this.modifiedDate = board.getUpdateDate();
    }
}
