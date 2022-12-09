package com.bomsbro.file.controller;


import com.bomsbro.file.model.dto.FileDto;
import com.bomsbro.file.service.FileService;
import com.bomsbro.global.model.dto.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileController {
    //TODO: Controller 에서 Dto<->Entity 전환
    //TODO: DtoWrapper? ResponseEntity? 로 감싸서 response
    private final FileService fileService;

    /*FileList Get Patch*/
    @GetMapping("/files")
    public ResponseEntity<ResponseWrapper<List<FileDto>>> getFileList (@RequestParam HashMap<String, String> paramMap, Pageable pageable) {
        List<FileDto> files = fileService.readAllFileList(pageable);
        return ResponseWrapper.ok(files, "get file list success.");
    }

    @PatchMapping("/files")
    public ResponseEntity<FileDto> patchFileList (){
        /*TODO: For List CUD with Json Patch*/
        // ResponseWrapper.ok(files, "patch file list success.");
        return null;
    }

    /*File File Get Put Delete */
    @PostMapping("/files")
    public ResponseEntity<ResponseWrapper<FileDto>>  fileFile ( @RequestBody FileDto requestDto) {
        //with path variable and body and optional param

        FileDto responseDto = fileService.createFile(requestDto);

        return ResponseWrapper.created(responseDto, "Create File Success.");
    }
    @GetMapping("files/{fileId}")
    public ResponseEntity<ResponseWrapper<FileDto>>  getFile (@PathVariable Long fileId) {
        //path variable and optional param
        FileDto file = fileService.readFile(fileId);
        return ResponseWrapper.ok(file, "get file list success.");
    }
    @PutMapping("files/{fileId}")
    public ResponseEntity<FileDto>  putFile (@PathVariable Long fileId,  @RequestBody FileDto requestDto) {
        //path variable and body optional param
        fileService.updateFile(requestDto);
        return null;
    }
    @DeleteMapping("files/{fileId}")
    public ResponseEntity<FileDto>  deleteFile (@PathVariable Long fileId) {
        //path variable and optional param
        fileService.deleteFile(fileId);
        return null;
    }
}
