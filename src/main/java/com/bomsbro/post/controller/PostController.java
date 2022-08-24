package com.bomsbro.post.controller;


import com.bomsbro.global.model.dto.ResponseWrapper;
import com.bomsbro.post.model.dto.PostDto;
import com.bomsbro.post.model.entity.Post;
import com.bomsbro.post.model.mapper.PostMapper;
import com.bomsbro.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    //TODO: Controller 에서 Dto<->Entity 전환
    //TODO: DtoWrapper? ResponseEntity? 로 감싸서 response
    private final PostService postService;
    private final PostMapper postMapper;

    /*PostList Get Patch*/
    @GetMapping("/posts")
    public ResponseEntity<ResponseWrapper<List<PostDto>>> getPostList (@RequestParam HashMap<String, String> paramMap, SpringDataWebProperties.Pageable pageable) {
        List<PostDto> posts = postMapper.convertEntityListToDto(postService.readPostList());
        return ResponseWrapper.ok(posts, "get post list success.");
    }

    @PatchMapping("/posts")
    public ResponseEntity<PostDto> patchPostList (){
        /*TODO: For List CUD with Json Patch*/
        // ResponseWrapper.ok(posts, "patch post list success.");
        return null;
    }

    /*Post Post Get Put Delete */
    @PostMapping("/posts")
    public ResponseEntity<ResponseWrapper<PostDto>>  postPost ( @RequestBody PostDto requestDto) {
        //with path variable and body and optional param
        Post post = postMapper.convertToEntity(requestDto);
        PostDto responseDto = postMapper.convertToDto(postService.createPost(post));

        return ResponseWrapper.created(responseDto, "Create Post Success.");
    }
    @GetMapping("/posts/{postId}")
    public ResponseEntity<ResponseWrapper<PostDto>>  getPost (@PathVariable Long postId) {
        //path variable and optional param
        PostDto post = postMapper.convertToDto(postService.readPost(postId));
        return ResponseWrapper.ok(post, "get post list success.");
    }
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto>  putPost (@PathVariable Long postId) {
        //path variable and body optional param
        postService.updatePost();
        return null;
    }
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<PostDto>  deletePost (@PathVariable Long postId) {
        //path variable and optional param
        postService.deletePost();
        return null;
    }
}
