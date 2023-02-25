package com.bomsbro.board.repository.jpa.board;


import com.bomsbro.global.model.entity.BaseTimeEntity;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Clob;
import java.time.LocalDateTime;

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
    private String title;
    @Lob
    private String content;
    private String writer;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
