package com.bomsbro.post.service.Impl;



import com.bomsbro.post.model.entity.PostCategory;
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

    @Override
    public List<PostCategory> readPostCategoryList() {
        return postCategoryRepository.findAll();
    }

    @Override
    @Transactional
    public int updatePostCategoryList() {
        return 0;
    }

    @Override
    @Transactional
    public PostCategory createPostCategory(PostCategory postCategory) {
        return postCategoryRepository.save(postCategory);
    }

    @Override
    public PostCategory readPostCategory(long postCategoryId) {
        return postCategoryRepository.findByPostCategoryId(postCategoryId);
    }

    @Override
    @Transactional
    public int updatePostCategory() {
        return 0;
    }

    @Override
    @Transactional
    public int deletePostCategory() {
        return 0;
    }

}
