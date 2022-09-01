package com.bomsbro.post.repository;


import com.bomsbro.post.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAll();

    Page<Post> findPostsByPostCategoryId(Long postCategoryId, Pageable pageable);

    Optional<Post> findById(long postId);

    Post save(Post post);

    void delete(Post post);
}
