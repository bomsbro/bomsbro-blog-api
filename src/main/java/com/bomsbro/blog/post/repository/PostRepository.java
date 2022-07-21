package com.bomsbro.blog.post.repository;

import com.bomsbro.blog.post.model.entity.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PostRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Post post) {
        em.persist(post);
        return post.getId();
    }

    public Post find(Long id) {
        return  em.find(Post.class, id);
    }
}
