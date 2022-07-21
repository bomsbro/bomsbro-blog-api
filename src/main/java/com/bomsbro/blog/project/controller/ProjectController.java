package com.bomsbro.blog.project.controller;

import com.bomsbro.blog.project.model.dto.ProjectDto;
import com.bomsbro.blog.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProjectController {
    //Controller 에서 Dto<->Entity 전환
    //DtoWrapper 로 감싸서 response
    private final ProjectService projectService;

    /*ProjectList RU*/
    /*get all 이랑 굳이 구분할 필요 있을까?*/

    @GetMapping("/projects")
    public ResponseEntity<ProjectDto>  getProjectList (@RequestParam HashMap<String, String> paramMap, Pageable pageable) {
        //with param
        return projectService.readProjectList();
    }

    @PatchMapping("/projects")
    public ResponseEntity<ProjectDto>  patchProjectList () {
        //with body and param
        //patch에서 id리스트만 받으면 delete id와 다른 컬럼들을 함께 받으면 update
        return projectService.updateProjectList();
    }

    /*Project CRUD*/
    @PostMapping("/projects/{projectId}")
    public ResponseEntity<ProjectDto>  postProject () {
        //with path variable and body and optional param
        return projectService.createProject();
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<ProjectDto>  getProject () {
        //path variable and optional param
        return projectService.readProject();
    }

    @PutMapping("/projects/{projectId}")
    public ResponseEntity<ProjectDto>  putProject () {
        //path variable and body optional param
        return projectService.updateProject();
    }

    @DeleteMapping("/projects/{projectId}")
    public ResponseEntity<ProjectDto>  deleteProject () {
        //path variable and optional param
        return projectService.deleteProject();
    }
}
