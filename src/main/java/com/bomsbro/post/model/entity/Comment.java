package com.bomsbro.post.model.entity;

import com.bomsbro.post.model.dto.CommentDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@SequenceGenerator(name = "comment_sequence_generator"
        , sequenceName = "seq_comment")
public class Comment {
    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comment")
    @Column(name = "cmt_id")
    private Long commentId;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post")
    private Post post;

    //Columns
    @Column(name = "cmt_content")
    private String commentContent;
}
