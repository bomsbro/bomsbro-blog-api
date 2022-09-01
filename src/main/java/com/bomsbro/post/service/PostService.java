package com.bomsbro.post.service;

import com.bomsbro.post.model.entity.Post;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    /*Post List CRUD*/
    public List<Post> readPostList(long postCategoryId, Pageable pageable);
    public int updatePostList();

    /*Post CRUD*/
    public Post createPost(Post post);
    public Post readPost(long postId);
    public Post updatePost(Post post);
    public int deletePost(long postId);
}
