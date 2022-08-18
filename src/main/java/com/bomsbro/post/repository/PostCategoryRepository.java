package com.bomsbro.post.repository;

import com.bomsbro.post.model.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {
    List<PostCategory> findAll();

    PostCategory findByPostCategoryId(long postCategoryId);
}
