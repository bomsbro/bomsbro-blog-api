package com.bomsbro.post.service.Impl;


import com.bomsbro.post.model.entity.Post;
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

    @Override
    public List<Post> readAllPostList(Pageable pageable) {
        return postRepository.findAll(pageable).toList();
    }

    @Override
    public List<Post> readPostList(long postCategoryId, Pageable pageable) {
        return postRepository.findPostsByPostCategoryId(postCategoryId, pageable).toList();
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
        return postRepository
                .findById(postId)
                .orElseThrow();
    }

    @Override
    @Transactional
    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public int deletePost(long postId) {
        postRepository.delete(readPost(postId));
        return 1;
    }

}
