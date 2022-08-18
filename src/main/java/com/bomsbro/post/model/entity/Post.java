package com.bomsbro.post.model.entity;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@SequenceGenerator(name = "post_sequence_generator"
        , sequenceName = "seq_post")
public class Post {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
    @Column(name = "post_id")
    private Long postId;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pca_id")
    private PostCategory postCategory;

    //Join
    @BatchSize(size = 40)
    @OneToMany(mappedBy = "post") // TODO cascade/delete-yn
    private final List<Comment> comments = new ArrayList<>();

    //Columns
    @Column(name = "post_title")
    private String title;

    @Lob
    @Column(name = "post_content")
    private String content;

    @Column(name = "post_preview_text")
    private String previewText;

    @Column(name = "post_view_count")
    private Integer viewCount;

    @Column(name = "post_reply_count")
    private Integer replyCount;
}
