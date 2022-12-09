package com.bomsbro.file.model.mapper;

import com.bomsbro.file.model.dto.FileDto;
import com.bomsbro.file.model.entity.File;
import com.bomsbro.global.model.mapper.GenericMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FileMapper extends GenericMapper<File, FileDto> {

    @Mapping(source = "fileCategory.id", target = "fileCategoryId")
    @Mapping(source = "fileCategory.name", target = "fileCategoryName")
    @Mapping(source = "user.id", target = "writerId")
    @Mapping(source = "user.name", target = "writerName")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FileDto convertToDto(File file);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<FileDto> convertEntityListToDto(List<File> files);
}
