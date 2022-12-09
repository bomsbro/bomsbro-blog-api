package com.bomsbro.file.service.Impl;


import com.bomsbro.file.model.dto.FileDto;
import com.bomsbro.file.model.entity.File;
import com.bomsbro.file.model.mapper.FileMapper;
import com.bomsbro.file.repository.FileRepository;
import com.bomsbro.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final FileMapper fileMapper;

    @Override
    public List<FileDto> readAllFileList(Pageable pageable) {
        return fileMapper.convertEntityListToDto(fileRepository.findAll(pageable).toList());
    }

    @Override
    public List<FileDto> readFileList(long fileCategoryId, Pageable pageable) {
        return fileMapper.convertEntityListToDto(fileRepository.findFilesByFileCategoryId(fileCategoryId, pageable).toList());
    }

    @Override
    @Transactional
    public int updateFileList() {
        return 0;
    }

    @Override
    @Transactional
    public FileDto createFile(FileDto fileDto) {
        File file = fileMapper.convertToEntity(fileDto);
        return fileMapper.convertToDto(fileRepository.save(file));
    }

    @Override
    public FileDto readFile(long fileId) {
        return fileMapper.convertToDto(fileRepository
                .findById(fileId)
                .orElseThrow());
    }

    @Override
    @Transactional
    public FileDto updateFile(FileDto fileDto) {
        File file = fileMapper.convertToEntity(fileDto);
        return fileMapper.convertToDto(fileRepository.save(file));
    }

    @Override
    @Transactional
    public int deleteFile(long fileId) {
        fileRepository.delete(
                fileRepository
                .findById(fileId)
                .orElseThrow()
        );
        return 1;
    }

}
