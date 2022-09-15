package com.bomsbro.user.repository;

import com.bomsbro.post.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Post, Long> {
}
