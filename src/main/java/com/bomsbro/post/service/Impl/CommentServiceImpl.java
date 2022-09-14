package com.bomsbro.post.service.Impl;

import com.bomsbro.post.model.dto.CommentDto;
import com.bomsbro.post.model.entity.Comment;
import com.bomsbro.post.model.mapper.CommentMapper;
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
    private final CommentMapper commentMapper;

    @Override
    public List<CommentDto> readCommentList() {
        return commentMapper.convertEntityListToDto(commentRepository.findAll());
    }

    @Override
    @Transactional
    public int updateCommentList() {
        return 0;
    }

    @Override
    @Transactional
    public CommentDto createComment(CommentDto.PostRequest requestDto) {
        Comment comment = commentMapper.convertToEntity(requestDto);
        return commentMapper.convertToDto(commentRepository.save(comment));
    }

    @Override
    public CommentDto readComment(long commentId) {
        return commentMapper.convertToDto(
                commentRepository
                .findById(commentId)
                .orElseThrow()
        );
    }

    @Override
    @Transactional
    public CommentDto updateComment(CommentDto.PutRequest requestDto) {
        Comment comment = commentMapper.convertToEntity(requestDto);
        return commentMapper.convertToDto(
                commentRepository.save(comment)
        );
    }

    @Override
    @Transactional
    public int deleteComment(long commentId) {
        commentRepository.delete(
                commentRepository
                .findById(commentId)
                .orElseThrow()
        );
        return 1;
    }

}
