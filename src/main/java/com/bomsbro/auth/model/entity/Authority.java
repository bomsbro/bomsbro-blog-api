package com.bomsbro.auth.model.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "auth_sequence_generator"
        , sequenceName = "seq_auth")
@Table(name="authority")
public class Authority {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_auth")
    @Column(name = "auth_id")
    private Long authorityId;

    //Columns
    @Column(name = "auth_name")
    private String authorityName;
}
