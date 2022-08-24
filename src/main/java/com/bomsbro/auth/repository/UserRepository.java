package com.bomsbro.auth.repository;

import com.bomsbro.auth.model.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "authorities") //Eager query Not Lazy
    Optional<User> findOneWithAuthoritiesByUserName(String userName);
}
