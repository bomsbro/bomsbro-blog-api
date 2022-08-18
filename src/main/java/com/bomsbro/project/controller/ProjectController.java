package com.bomsbro.project.controller;

import com.bomsbro.common.model.dto.ResponseWrapper;
import com.bomsbro.project.model.dto.ProjectDto;
import com.bomsbro.project.model.entity.Project;
import com.bomsbro.project.model.mapper.ProjectMapper;
import com.bomsbro.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProjectController {
    //TODO: Controller 에서 Dto<->Entity 전환
    //TODO: DtoWrapper? ResponseEntity? 로 감싸서 response
    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    /*ProjectList Get Patch*/
    @GetMapping("/projects")
    public ResponseEntity<ResponseWrapper<List<ProjectDto>>>  getProjectList (@RequestParam HashMap<String, String> paramMap, Pageable pageable) {
        List<ProjectDto> projects = projectMapper.convertEntityListToDto(projectService.readProjectList());
        return ResponseWrapper.ok(projects, "get post list success.");
    }

    @PatchMapping("/projects")
    public  ResponseEntity<ProjectDto> patchProjectList (){
        /*TODO: For List CUD with Json Patch*/
       // ResponseWrapper.ok(projects, "patch post list success.");
        return null;
    }

    /*Project Post Get Put Delete */
    @PostMapping("/projects")
    public ResponseEntity<ResponseWrapper<ProjectDto>>  postProject ( @RequestBody ProjectDto requestDto) {
        //with path variable and body and optional param
        Project project = projectMapper.convertToEntity(requestDto);
        ProjectDto responseDto = projectMapper.convertToDto(projectService.createProject(project));

        return ResponseWrapper.created(responseDto, "Create Project Success.");
    }
    @GetMapping("/projects/{projectId}")
    public ResponseEntity<ResponseWrapper<ProjectDto>>  getProject (@PathVariable Long projectId) {
        //path variable and optional param
        ProjectDto project = projectMapper.convertToDto(projectService.readProject(projectId));
        return ResponseWrapper.ok(project, "get post list success.");
    }
    @PutMapping("/projects/{projectId}")
    public ResponseEntity<ProjectDto>  putProject (@PathVariable Long projectId) {
        //path variable and body optional param
        projectService.updateProject();
        return null;
    }
    @DeleteMapping("/projects/{projectId}")
    public ResponseEntity<ProjectDto>  deleteProject (@PathVariable Long projectId) {
        //path variable and optional param
        projectService.deleteProject();
        return null;
    }
}
