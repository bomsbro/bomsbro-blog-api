package com.bomsbro.post.service.Impl;


import com.bomsbro.post.model.entity.Post;
import com.bomsbro.post.repository.PostRepository;
import com.bomsbro.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> readPostList() {
        return postRepository.findAll();
    }

    @Override
    @Transactional
    public int updatePostList() {
        return 0;
    }

    @Override
    @Transactional
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post readPost(long postId) {
        return postRepository.findByPostId(postId);
    }

    @Override
    @Transactional
    public int updatePost() {
        return 0;
    }

    @Override
    @Transactional
    public int deletePost() {
        return 0;
    }

}
