package com.bomsbro.post.service;

import com.bomsbro.post.model.entity.Comment;

import java.util.List;

public interface CommentService {

    /*Comment List CRUD*/
    public List<Comment> readCommentList();
    public int updateCommentList();

    /*Comment CRUD*/
    public Comment createComment(Comment comment);
    public Comment readComment(long commentId);
    public int updateComment();
    public int deleteComment();
}