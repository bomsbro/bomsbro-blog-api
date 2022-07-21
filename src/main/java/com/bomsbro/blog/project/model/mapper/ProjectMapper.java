package com.bomsbro.blog.project.model.mapper;

import com.bomsbro.blog.project.model.dto.ProjectDto;
import com.bomsbro.blog.project.model.entity.Project;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends GenericMapper<Project, ProjectDto> {
    @Mapping(target = "reactions", ignore = true)
    @Mapping(source = "board.id", target = "boardId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProjectDto convertToDto(Project post);
}
