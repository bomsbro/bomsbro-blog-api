package com.bomsbro.board.repository.jpa.boardFile;

import com.bomsbro.board.domain.BoardFileStatus;
import com.bomsbro.board.domain.BoardStatus;
import com.bomsbro.board.repository.jpa.board.BoardReadEntity;
import com.bomsbro.global.model.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Where;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Immutable
@Table(name = "board_file")
@Transactional(readOnly = true)
@Where(clause = "deleted = false")
@NoArgsConstructor(access = PROTECTED)
public class BoardFileReadEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BoardStatus boardStatus;
    private Long boardId;
    private String fileName;
    private String filePath;
    private String fileDownloadUri;

    @ManyToOne
    private BoardReadEntity boardReadEntity;

    @Enumerated(EnumType.STRING)
    private BoardFileStatus status;
}
