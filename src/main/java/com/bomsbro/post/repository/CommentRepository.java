package com.bomsbro.post.repository;


import com.bomsbro.post.model.entity.Comment;
import com.bomsbro.post.model.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAll();

    Optional<Comment> findById(long commentId);

    Comment save(Comment comment);

    void delete(Comment comment);
}
