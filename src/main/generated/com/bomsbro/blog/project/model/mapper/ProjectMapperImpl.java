package com.bomsbro.blog.project.model.mapper;

import com.bomsbro.blog.project.model.dto.ProjectDto;
import com.bomsbro.blog.project.model.dto.ProjectDto.ProjectDtoBuilder;
import com.bomsbro.blog.project.model.entity.Project;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-26T15:59:38+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public Project convertToEntity(ProjectDto dto) {
        if ( dto == null ) {
            return null;
        }

        Project project = new Project();

        project.setProjectId( dto.getProjectId() );
        project.setProjectName( dto.getProjectName() );
        project.setProjectDescription( dto.getProjectDescription() );
        project.setProjectGithubUrl( dto.getProjectGithubUrl() );
        project.setProjectServiceUrl( dto.getProjectServiceUrl() );

        return project;
    }

    @Override
    public List<Project> convertDtoListToEntity(List<ProjectDto> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Project> list = new ArrayList<Project>( dto.size() );
        for ( ProjectDto projectDto : dto ) {
            list.add( convertToEntity( projectDto ) );
        }

        return list;
    }

    @Override
    public ProjectDto convertToDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDtoBuilder projectDto = ProjectDto.builder();

        projectDto.projectId( project.getProjectId() );
        projectDto.projectName( project.getProjectName() );
        projectDto.projectDescription( project.getProjectDescription() );
        projectDto.projectGithubUrl( project.getProjectGithubUrl() );
        projectDto.projectServiceUrl( project.getProjectServiceUrl() );

        return projectDto.build();
    }

    @Override
    public List<ProjectDto> convertEntityListToDto(List<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        List<ProjectDto> list = new ArrayList<ProjectDto>( projects.size() );
        for ( Project project : projects ) {
            list.add( convertToDto( project ) );
        }

        return list;
    }
}
