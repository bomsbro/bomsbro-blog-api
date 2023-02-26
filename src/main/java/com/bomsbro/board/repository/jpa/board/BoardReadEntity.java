package com.bomsbro.board.repository.jpa.board;

import com.bomsbro.global.model.entity.BaseTimeEntity;
import lombok.NoArgsConstructor;
import org.checkerframework.common.aliasing.qual.Unique;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Where;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

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
    @Unique
    private UUID uuid;
    private String title;
    @Lob
    private String content;
    private String writer;

    private LocalDateTime created;
}
