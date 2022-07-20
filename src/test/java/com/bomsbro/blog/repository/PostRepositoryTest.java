package com.bomsbro.blog.repository;

import com.bomsbro.blog.model.entity.Post;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired PostRepository postRepository;

    @Test
    @Transactional
    public void testPost() throws  Exception {
        //given
        Post post = new Post();
        post.setTitle("하이하이");
        post.setContent("만나서 반가워");
        //when
        Long postId = postRepository.save(post);
        Post postFound = postRepository.find(postId);
        //then
        Assertions.assertEquals(postFound.getId(), postId);
    }
}