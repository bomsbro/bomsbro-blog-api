package com.bomsbro.blog.project.repository;

import com.bomsbro.blog.project.model.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAll();
    //TODO: find by userId
    // Page<Project> find(long userId , Pageable pageable);

    Project findByProjectId(long projectId);
}
