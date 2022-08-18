package com.bomsbro.post.service;

import com.bomsbro.post.model.entity.Post;

import java.util.List;

public interface PostService {

    /*Post List CRUD*/
    public List<Post> readPostList();
    public int updatePostList();

    /*Post CRUD*/
    public Post createPost(Post post);
    public Post readPost(long postId);
    public int updatePost();
    public int deletePost();
}
