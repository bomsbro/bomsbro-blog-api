package com.bomsbro.board.repository.jpa.board;

import com.bomsbro.global.model.entity.BaseTimeEntity;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Where;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Immutable
@Table(name = "board")
@Transactional(readOnly = true)
@Where(clause = "deleted = false")
@NoArgsConstructor(access = PROTECTED)
public class BoardReadEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    private String content;
    private String writer;

    private LocalDateTime created;
}
