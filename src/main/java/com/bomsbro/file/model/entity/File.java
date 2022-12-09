package com.bomsbro.file.model.entity;


import com.bomsbro.global.model.entity.BaseTimeEntity;
import com.bomsbro.post.model.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "file_sequence_generator"
        , sequenceName = "seq_file")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="file")
public class File extends BaseTimeEntity {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_file")
    @Column(name = "file_id")
    private Long id;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    //Columns
    @Column(name = "file_title")
    private String title;

    @Lob
    @Column(name = "file_content")
    private String content;

    @Column(name = "file_preview_text")
    private String previewText;

    @Column(name = "file_view_count")
    private Long viewCount;

    @Column(name = "file_reply_count")
    private Long replyCount;

}
