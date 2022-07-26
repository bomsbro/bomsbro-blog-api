package com.bomsbro.blog.post.model.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter @Setter
@SequenceGenerator(name = "post_sequence_generator"
        , sequenceName = "seq_post")
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_post")
    private Long id;

    private String title;
    @Lob
    private String content; // html

}
