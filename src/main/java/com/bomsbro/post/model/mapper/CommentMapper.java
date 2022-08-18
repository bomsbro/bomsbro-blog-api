package com.bomsbro.post.model.mapper;

import com.bomsbro.common.model.mapper.GenericMapper;
import com.bomsbro.post.model.entity.Comment;
import com.bomsbro.post.model.dto.CommentDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper extends GenericMapper<Comment, CommentDto> {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CommentDto convertToDto(Comment comment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<CommentDto> convertEntityListToDto(List<Comment> comments);
}
