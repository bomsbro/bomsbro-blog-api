package com.bomsbro.user.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="user")
public class User {
    //PK
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    //Columns
    @NonNull
    @Column(name = "user_name", length=500, unique = true)
    private String name;

    @NonNull
    @Column(name = "user_password",length = 100)
    private String password;

    @Column(name = "user_nickname", length=50, unique = true)
    private String nickname;

    @Column(name = "user_activated")
    private Boolean activated;

    //Join
    @NonNull
    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="auth_id", referencedColumnName = "auth_id")}
    )
    private Set<Authority> userAuthorities;
}
