package com.bomsbro.blog.post.service;

import com.bomsbro.blog.post.model.entity.Post;
import com.bomsbro.blog.project.model.entity.Project;

import java.util.List;

public interface PostService {
//    public List<Post> findAll();
    public List<Post> readPostList();

    public int updatePostList();

    /*Project CRUD*/
    public Post createPost(Post post);
    public Post readPost(long postId);
    public int updatePost();
    public int deletePost();
}
