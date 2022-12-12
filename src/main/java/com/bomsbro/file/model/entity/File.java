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
    private Long fileId;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    //Columns
    @Column(name = "file_name", unique=true)
    private Long fileName;

    @Column(name = "file_org_name")
    private String fileOrgName;

    @Lob
    @Column(name = "file_extension")
    private String fileExtension;

    @Column(name = "file_size")
    private String fileSize;

    @Column(name = "file_url")
    private String fileUrl;
}
