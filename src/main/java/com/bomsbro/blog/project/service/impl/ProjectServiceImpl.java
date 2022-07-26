package com.bomsbro.blog.project.service.impl;

import com.bomsbro.blog.project.model.entity.Project;
import com.bomsbro.blog.project.repository.ProjectRepository;
import com.bomsbro.blog.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public List<Project> readProjectList() {
        return projectRepository.findAll();
    }

    @Override
    @Transactional
    public int updateProjectList() {
        return 0;
    }

    @Override
    @Transactional
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project readProject(long projectId) {
        return projectRepository.findByProjectId(projectId);
    }

    @Override
    @Transactional
    public int updateProject() {
        return 0;
    }

    @Override
    @Transactional
    public int deleteProject() {
        return 0;
    }

}
