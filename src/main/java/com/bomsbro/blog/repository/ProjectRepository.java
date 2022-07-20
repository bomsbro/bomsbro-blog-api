package com.bomsbro.blog.repository;

import com.bomsbro.blog.model.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> selectAll();
    List<Project> selectByProjectId(long projectId);
    Page<Project> selectByUserId(long userId , Pageable pageable);
}
