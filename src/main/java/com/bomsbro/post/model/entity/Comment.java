package com.bomsbro.post.model.entity;

import com.bomsbro.post.model.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="comment")
@SequenceGenerator(name = "comment_sequence_generator"
        , sequenceName = "seq_comment")
public class Comment {
    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comment")
    @Column(name = "cmt_id")
    private Long id;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post")
    private Post post;

    //Columns
    @Column(name = "cmt_content")
    private String content;
}
