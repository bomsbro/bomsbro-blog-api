package com.bomsbro.post.service.Impl;


import com.bomsbro.post.model.dto.PostDto;
import com.bomsbro.post.model.entity.Post;
import com.bomsbro.post.model.mapper.PostMapper;
import com.bomsbro.post.repository.PostRepository;
import com.bomsbro.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public List<PostDto> readAllPostList(Pageable pageable) {
        return postMapper.convertEntityListToDto(postRepository.findAll(pageable).toList());
    }

    @Override
    public List<PostDto> readPostList(long postCategoryId, Pageable pageable) {
        return postMapper.convertEntityListToDto(postRepository.findPostsByPostCategoryId(postCategoryId, pageable).toList());
    }

    @Override
    @Transactional
    public int updatePostList() {
        return 0;
    }

    @Override
    @Transactional
    public PostDto createPost(PostDto postDto) {
        Post post = postMapper.convertToEntity(postDto);
        return postMapper.convertToDto(postRepository.save(post));
    }

    @Override
    public PostDto readPost(long postId) {
        return postMapper.convertToDto(postRepository
                .findById(postId)
                .orElseThrow());
    }

    @Override
    @Transactional
    public PostDto updatePost(PostDto postDto) {
        Post post = postMapper.convertToEntity(postDto);
        return postMapper.convertToDto(postRepository.save(post));
    }

    @Override
    @Transactional
    public int deletePost(long postId) {
        postRepository.delete(
                postRepository
                .findById(postId)
                .orElseThrow()
        );
        return 1;
    }

}
