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

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FileDto convertToDto(File file);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<FileDto> convertEntityListToDto(List<File> files);
}
