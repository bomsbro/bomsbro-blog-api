package com.bomsbro.user.model.entity;

import com.bomsbro.post.model.entity.Comment;
import com.bomsbro.post.model.entity.PostCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //PK
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    //Join
    @ManyToMany
    @JoinTable(
            name = "user_authtoriy",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="auth_name", referencedColumnName = "auth_id")}
    )
    private Set<Authority> authorities;

    //Columns
    @Column(name = "user_password")
    private long password;

    @Column(name = "user_name", length=50, unique = true)
    private String name;

    @Column(name = "user_nickname", length=50, unique = true)
    private String nickname;

    @Column(name = "activated")
    private Boolean activated;
}
