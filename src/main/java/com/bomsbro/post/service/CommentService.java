package com.bomsbro.post.service;

import com.bomsbro.post.model.dto.CommentDto;
import com.bomsbro.post.model.entity.Comment;

import java.util.List;

public interface CommentService {

    /*Comment List CRUD*/
    public List<CommentDto> readCommentList();
    public int updateCommentList();

    /*Comment CRUD*/
    public CommentDto createComment(CommentDto.PostRequest comment);
    public CommentDto readComment(long commentId);
    public CommentDto updateComment(CommentDto.PutRequest comment);
    public int deleteComment(long commentId);
}