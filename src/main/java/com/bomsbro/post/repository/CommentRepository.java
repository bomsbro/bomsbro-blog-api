package com.bomsbro.post.repository;


import com.bomsbro.post.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAll();

    Comment findByCommentId(long commentId);
}
