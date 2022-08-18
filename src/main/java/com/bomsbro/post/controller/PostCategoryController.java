package com.bomsbro.post.controller;



import com.bomsbro.common.model.dto.ResponseWrapper;
import com.bomsbro.post.model.dto.PostCategoryDto;
import com.bomsbro.post.model.entity.PostCategory;
import com.bomsbro.post.model.mapper.PostCategoryMapper;
import com.bomsbro.post.service.PostCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

//TODO: Controller 에서 Dto<->Entity 전환
//TODO: DtoWrapper? ResponseEntity? 로 감싸서 response
//TODO: 복수의 자료는 json patch 사용

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostCategoryController {

    private final PostCategoryService postCategoryService;
    private final PostCategoryMapper postCategoryMapper;

    /*PostCategoryList Get Patch*/
    @GetMapping("/post-categories")
    public ResponseEntity<ResponseWrapper<List<PostCategoryDto>>> getPostCategoryList (@RequestParam HashMap<String, String> paramMap, SpringDataWebProperties.Pageable pageable) {
        List<PostCategoryDto> postCategorys = postCategoryMapper.convertEntityListToDto(postCategoryService.readPostCategoryList());
        return ResponseWrapper.ok(postCategorys, "get post list success.");
    }

    @PatchMapping("/post-categories")
    public  ResponseEntity<PostCategoryDto> patchPostCategoryList (){
        /*TODO: For List CUD with Json Patch*/
        // ResponseWrapper.ok(postCategorys, "patch post list success.");
        return null;
    }

    /*PostCategory Post Get Put Delete */
    @PostMapping("/post-categories")
    public ResponseEntity<ResponseWrapper<PostCategoryDto>>  postPostCategory ( @RequestBody PostCategoryDto requestDto) {
        //with path variable and body and optional param
        PostCategory postCategory = postCategoryMapper.convertToEntity(requestDto);
        PostCategoryDto responseDto = postCategoryMapper.convertToDto(postCategoryService.createPostCategory(postCategory));

        return ResponseWrapper.created(responseDto, "Create PostCategory Success.");
    }
    @GetMapping("/post-categories/{postCategoryId}")
    public ResponseEntity<ResponseWrapper<PostCategoryDto>>  getPostCategory (@PathVariable Long postCategoryId) {
        //path variable and optional param
        PostCategoryDto postCategory = postCategoryMapper.convertToDto(postCategoryService.readPostCategory(postCategoryId));
        return ResponseWrapper.ok(postCategory, "get post list success.");
    }
    @PutMapping("/post-categories/{postCategoryId}")
    public ResponseEntity<PostCategoryDto>  putPostCategory (@PathVariable Long postCategoryId) {
        //path variable and body optional param
        postCategoryService.updatePostCategory();
        return null;
    }
    @DeleteMapping("/post-categories/{postCategoryId}")
    public ResponseEntity<PostCategoryDto>  deletePostCategory (@PathVariable Long postCategoryId) {
        //path variable and optional param
        postCategoryService.deletePostCategory();
        return null;
    }
}
