package com.bomsbro.post.service.Impl;

import com.bomsbro.post.model.entity.Comment;
import com.bomsbro.post.repository.CommentRepository;
import com.bomsbro.post.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public List<Comment> readCommentList() {
        return commentRepository.findAll();
    }

    @Override
    @Transactional
    public int updateCommentList() {
        return 0;
    }

    @Override
    @Transactional
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment readComment(long commentId) {
        return commentRepository.findByCommentId(commentId);
    }

    @Override
    @Transactional
    public int updateComment() {
        return 0;
    }

    @Override
    @Transactional
    public int deleteComment() {
        return 0;
    }

}
