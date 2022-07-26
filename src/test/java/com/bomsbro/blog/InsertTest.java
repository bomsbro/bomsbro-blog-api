package com.bomsbro.blog;

import com.bomsbro.blog.post.model.entity.Post;
import com.bomsbro.blog.project.model.entity.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;

//@RunWith(SpringRunner.class) // JUnit 4에서 쓰던 것
@SpringBootTest
@Transactional
public class InsertTest {

    @Autowired
    EntityManager em ;

    @Autowired
    Post post;

    @Autowired
    Project project;

    @Test
    public void 포스트_추가() throws Exception {

        post = createPost();
        assertEquals("Post 제목", "제목입니다.",  post.getTitle());
        assertEquals("Post 내용", "안녕하세요.html", post.getContent());

        System.out.println(Post.class);
    }

    @Test
    public void 프로젝트_추가() throws Exception {
        project = createProject();

        assertEquals("Project 제목", "제목입니다.",  project.getProjectName());
        assertEquals("Project 내용", "안녕하세요.html", project.getProjectDescription());

        System.out.println(Project.class);
    }

    private Post createPost() {
        Post post = new Post();
        post.setTitle("제목입니다.");
        post.setContent("안녕하세요.html");
        return post;
    }

    private Project createProject() {
        Project project1 = new Project();
        project1.setProjectName("제목입니다.");
        project1.setProjectDescription("안녕하세요.html");
        project1.setProjectGithubUrl("zzz");
        project1.setProjectServiceUrl("www");

        return project1;
    }
}
