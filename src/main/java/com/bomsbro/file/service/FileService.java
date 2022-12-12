package com.bomsbro.file.service;


import com.bomsbro.file.model.dto.FileDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FileService {
    /*Read Upload Url*/
    public  String readUploadUrl(String fileName);

    /*File List CRUD*/
    public List<FileDto> readAllFileList(Pageable pageable);
    public List<FileDto> readFileList(long fileCategoryId, Pageable pageable);
    public int updateFileList();

    /*File CRUD*/
    public FileDto createFile(FileDto fileDto);
    public FileDto readFile(long fileId);
    public FileDto updateFile(FileDto fileDto);
    public int deleteFile(long fileId);
}
