package com.bomsbro.blog.post.model;

import com.bomsbro.blog.post.model.dto.PostDto;
import com.bomsbro.blog.post.model.entity.Post;

import com.bomsbro.blog.project.model.mapper.GenericMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper extends GenericMapper<Post, PostDto> {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostDto convertToDto(Post post);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<PostDto> convertEntityListToDto(List<Post> post);
}
