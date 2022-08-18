package com.bomsbro.post.service;

import com.bomsbro.post.model.entity.PostCategory;

import java.util.List;

public interface PostCategoryService {

    /*PostCategory List CRUD*/
    public List<PostCategory> readPostCategoryList();
    public int updatePostCategoryList();

    /*PostCategory CRUD*/
    public PostCategory createPostCategory(PostCategory postCategory);
    public PostCategory readPostCategory(long postCategoryId);
    public int updatePostCategory();
    public int deletePostCategory();
}
