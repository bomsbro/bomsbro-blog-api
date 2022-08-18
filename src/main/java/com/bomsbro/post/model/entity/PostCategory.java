package com.bomsbro.post.model.entity;

import com.bomsbro.post.model.dto.PostCategoryDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@SequenceGenerator(name = "post_category_sequence_generator"
        , sequenceName = "seq_post_category")
public class PostCategory {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post_category")
    @Column(name = "pca_id")
    private Long postCategoryId;

    //Join
    @BatchSize(size = 40)
    @OneToMany(mappedBy = "postCategory") // TODO cascade/delete-yn
    private final List<Post> posts = new ArrayList<>();

    @Column(name = "pca_name")
    private String name;

    @Column(name = "pca_order")
    private Long order;

    //builder
    public static PostCategory of(PostCategoryDto.PostPostCategoryRequestDto dto) {
        return PostCategory.builder()
                .name(dto.getName())
                .build();
    }

}
