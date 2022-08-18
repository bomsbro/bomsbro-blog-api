package com.bomsbro.user.model.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "post_sequence_generator"
        , sequenceName = "seq_post")
public class Authority {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
    @Column(name = "auth_id")
    private Long authorityId;

    //Columns
    @Column(name = "auth_name")
    private String name;
}
