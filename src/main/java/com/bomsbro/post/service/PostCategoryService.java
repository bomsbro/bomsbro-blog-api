package com.bomsbro.post.service;

import com.bomsbro.post.model.dto.PostCategoryDto;
import com.bomsbro.post.model.entity.PostCategory;

import java.util.List;

public interface PostCategoryService {

    /*PostCategory List CRUD*/
    public List<PostCategoryDto> readPostCategoryList();
    public int updatePostCategoryList();

    /*PostCategory CRUD*/
    public PostCategoryDto createPostCategory(PostCategoryDto.PostRequest postCategory);
    public PostCategoryDto readPostCategory(long postCategoryId);
    public PostCategoryDto updatePostCategory(PostCategoryDto.PutRequest postCategory);
    public int deletePostCategory(long postCategoryId);
}
