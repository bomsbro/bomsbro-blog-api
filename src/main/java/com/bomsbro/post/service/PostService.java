package com.bomsbro.post.service;

import com.bomsbro.post.model.dto.PostDto;
import com.bomsbro.post.model.entity.Post;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    /*Post List CRUD*/
    public List<PostDto> readAllPostList(Pageable pageable);
    public List<PostDto> readPostList(long postCategoryId, Pageable pageable);
    public int updatePostList();

    /*Post CRUD*/
    public PostDto createPost(PostDto postDto);
    public PostDto readPost(long postId);
    public PostDto updatePost(PostDto postDto);
    public int deletePost(long postId);
}
