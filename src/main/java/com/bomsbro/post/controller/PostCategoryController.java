package com.bomsbro.post.controller;



import com.bomsbro.global.model.dto.ResponseWrapper;
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
@RequestMapping("/post-categories")
@RequiredArgsConstructor
public class PostCategoryController {

    private final PostCategoryService postCategoryService;

    /*PostCategoryList Get Patch*/
    @GetMapping("")
    public ResponseEntity<ResponseWrapper<List<PostCategoryDto>>> getPostCategoryList (@RequestParam HashMap<String, String> paramMap, SpringDataWebProperties.Pageable pageable) {
        List<PostCategoryDto> postCategories = postCategoryService.readPostCategoryList();
        return ResponseWrapper.ok(postCategories, "Get post category list success.");
    }

    @PatchMapping("")
    public  ResponseEntity<PostCategoryDto> patchPostCategoryList (){
        /*TODO: For List CUD with Json Patch*/
        // ResponseWrapper.ok(postCategorys, "patch post list success.");
        return null;
    }

    /*PostCategory Post Get Put Delete */
    @PostMapping("")
    public ResponseEntity<ResponseWrapper<PostCategoryDto>>  postPostCategory ( @RequestBody PostCategoryDto.PostRequest requestDto) {
        PostCategory postCategory = PostCategory.of(requestDto);
        PostCategoryDto responseDto = postCategoryService.createPostCategory(requestDto);

        return ResponseWrapper.created(responseDto, "Post post category Success.");
    }
    @GetMapping("/{postCategoryId}")
    public ResponseEntity<ResponseWrapper<PostCategoryDto>>  getPostCategory (@PathVariable Long postCategoryId) {
        PostCategoryDto postCategory = postCategoryService.readPostCategory(postCategoryId);
        return ResponseWrapper.ok(postCategory, "Get post category success.");
    }
    @PutMapping("/{postCategoryId}")
    public ResponseEntity<ResponseWrapper<PostCategoryDto>>  putPostCategory (@PathVariable Long postCategoryId, @RequestBody PostCategoryDto.PutRequest requestDto) {
        PostCategoryDto responseDto = postCategoryService.updatePostCategory(requestDto);
        return ResponseWrapper.created(responseDto, "Post post category Success.");
    }
    @DeleteMapping("/{postCategoryId}")
    public ResponseEntity<PostCategoryDto>  deletePostCategory (@PathVariable Long postCategoryId) {
        postCategoryService.deletePostCategory(postCategoryId);
        return null;
    }
}
