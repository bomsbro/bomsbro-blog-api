package com.bomsbro.post.repository;

import com.bomsbro.post.model.entity.Post;
import com.bomsbro.post.model.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {
    List<PostCategory> findAll();

    Optional<PostCategory> findById(long postCategoryId);

    PostCategory save(PostCategory postCategory);

    void delete(PostCategory postCategory);
}
