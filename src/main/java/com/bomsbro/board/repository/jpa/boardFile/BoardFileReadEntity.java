package com.bomsbro.board.repository.jpa.boardFile;

import com.bomsbro.board.domain.BoardFile;
import com.bomsbro.board.domain.BoardFileStatus;
import com.bomsbro.board.repository.jpa.board.BoardReadEntity;
import com.bomsbro.global.model.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import java.nio.file.Path;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Immutable
@Table(name = "board_file")
@Transactional(readOnly = true)
@NoArgsConstructor(access = PROTECTED)
public class BoardFileReadEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String filePath;

    @Enumerated(EnumType.STRING)
    private BoardFileStatus status;

    @JoinColumn(name = "boardId")
    @ManyToOne(fetch = FetchType.LAZY)
    private BoardReadEntity boardReadEntity;

    public BoardFile toDomain() {
        return new BoardFile(this.id, boardReadEntity.getBoardId(), this.fileName, Path.of(this.filePath), this.status);
    }
}
