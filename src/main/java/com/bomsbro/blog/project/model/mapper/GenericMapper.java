package com.bomsbro.blog.project.model.mapper;

import org.mapstruct.*;

import java.util.List;

public interface GenericMapper<Entity, Dto> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Dto convertToDto(Entity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Entity convertToEntity(Dto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<Dto> convertEntityListToDto(List<Entity> entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<Entity> convertDtoListToEntity(List<Dto> dto);
}
