package com.bomsbro.project.model.mapper;

import com.bomsbro.common.model.mapper.GenericMapper;
import com.bomsbro.project.model.dto.ProjectDto;
import com.bomsbro.project.model.entity.Project;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends GenericMapper<Project, ProjectDto> {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProjectDto convertToDto(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<ProjectDto> convertEntityListToDto(List<Project> projects);
}
