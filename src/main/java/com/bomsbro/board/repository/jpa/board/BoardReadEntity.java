package com.bomsbro.board.repository.jpa.board;

import com.bomsbro.board.domain.BoardStatus;
import com.bomsbro.board.repository.jpa.boardFile.BoardFileReadEntity;
import com.bomsbro.global.model.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Where;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Immutable
@Table(name = "board")
@Transactional(readOnly = true)
@Where(clause = "deleted = false")
@NoArgsConstructor(access = PROTECTED)
public class BoardReadEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    private String title;
    @Lob
    private String content;
    private String writer;
    private Boolean deleted;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "boardReadEntity")
    private List<BoardFileReadEntity> boardFileReadEntity;

    @Enumerated(EnumType.STRING)
    private BoardStatus boardStatus;
}
