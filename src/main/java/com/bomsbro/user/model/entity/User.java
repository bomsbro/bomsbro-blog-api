package com.bomsbro.user.model.entity;

import com.bomsbro.post.model.entity.Comment;
import com.bomsbro.post.model.entity.PostCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class User {
    //PK
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    //Columns
    @Column(name = "user_name", length=500, unique = true)
    private String name;

    @Column(name = "user_password", length=50, unique = true)
    private long password;

    @Column(name = "user_nickname", length=50, unique = true)
    private String nickname;

    @Column(name = "user_activated")
    private Boolean activated;

    //Join
    @ManyToMany
    @JoinTable(
            name = "user_authtoriy",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="auth_name", referencedColumnName = "auth_id")}
    )
    private Set<Authority> authorities;

}
