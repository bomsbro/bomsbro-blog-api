package com.bomsbro.post.model.mapper;

import com.bomsbro.global.model.mapper.GenericMapper;
import com.bomsbro.post.model.dto.PostDto;
import com.bomsbro.post.model.entity.Post;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper extends GenericMapper<Post, PostDto> {

    @Mapping(source = "postCategory.id", target = "postCategoryId")
    @Mapping(source = "user.id", target = "userId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostDto convertToDto(Post post);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<PostDto> convertEntityListToDto(List<Post> posts);
}
