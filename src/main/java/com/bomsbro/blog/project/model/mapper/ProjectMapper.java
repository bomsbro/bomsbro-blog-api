package com.bomsbro.blog.project.model.mapper;

import com.bomsbro.blog.project.model.dto.ProjectDto;
import com.bomsbro.blog.project.model.entity.Project;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends GenericMapper<Project, ProjectDto> {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProjectDto convertToDto(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<ProjectDto> convertEntityListToDto(List<Project> projects);
}
