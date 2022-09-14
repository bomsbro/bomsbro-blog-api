package com.bomsbro.post.service.Impl;



import com.bomsbro.post.model.dto.PostCategoryDto;
import com.bomsbro.post.model.entity.PostCategory;
import com.bomsbro.post.model.mapper.PostCategoryMapper;
import com.bomsbro.post.repository.PostCategoryRepository;
import com.bomsbro.post.service.PostCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PostCategoryServiceImpl implements PostCategoryService {

    private final PostCategoryRepository postCategoryRepository;
    private final PostCategoryMapper postCategoryMapper;

    @Override
    public List<PostCategoryDto> readPostCategoryList() {
        return postCategoryMapper.convertEntityListToDto(postCategoryRepository.findAll());
    }

    @Override
    @Transactional
    public int updatePostCategoryList() {
        return 0;
    }

    @Override
    @Transactional
    public PostCategoryDto createPostCategory(PostCategoryDto.PostRequest requestDto) {
        PostCategory postCategory = PostCategory.of(requestDto);
        return postCategoryMapper.convertToDto(postCategoryRepository.save(postCategory));
    }

    @Override
    public PostCategoryDto readPostCategory(long postCategoryId) {
        return postCategoryMapper.convertToDto(
                postCategoryRepository
                .findById(postCategoryId)
                .orElseThrow()
        );
    }

    @Override
    @Transactional
    public PostCategoryDto updatePostCategory (PostCategoryDto.PutRequest requestDto) {
        PostCategory postCategory = PostCategory.of(requestDto);
        return postCategoryMapper.convertToDto(
                postCategoryRepository.save(postCategory)
        );
    }

    @Override
    @Transactional
    public int deletePostCategory(long postCategoryId) {
        postCategoryRepository.delete(
                postCategoryRepository
                        .findById(postCategoryId)
                        .orElseThrow()
        );
        return 1;
    }

}
