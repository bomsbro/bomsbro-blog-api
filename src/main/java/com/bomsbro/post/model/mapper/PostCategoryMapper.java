package com.bomsbro.post.model.mapper;

import com.bomsbro.common.model.mapper.GenericMapper;
import com.bomsbro.post.model.dto.PostCategoryDto;
import com.bomsbro.post.model.entity.PostCategory;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PostCategoryMapper extends GenericMapper<PostCategory, PostCategoryDto> {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostCategoryDto convertToDto(PostCategory postCategory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<PostCategoryDto> convertEntityListToDto(List<PostCategory> postCategorys);
}
