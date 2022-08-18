package com.bomsbro.post.repository;

import com.bomsbro.post.model.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {
    List<PostCategory> findAll();

    PostCategory findByPostCategoryId(long postCategoryId);
}
