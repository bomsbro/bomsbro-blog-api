package com.bomsbro.post.controller;


import com.bomsbro.global.model.dto.ResponseWrapper;
import com.bomsbro.post.model.dto.PostDto;
import com.bomsbro.post.model.entity.Post;
import com.bomsbro.post.model.mapper.PostMapper;
import com.bomsbro.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    //TODO: Controller 에서 Dto<->Entity 전환
    //TODO: DtoWrapper? ResponseEntity? 로 감싸서 response
    private final PostService postService;

    /*PostList Get Patch*/
    @GetMapping("/posts")
    public ResponseEntity<ResponseWrapper<List<PostDto>>> getPostList ( @RequestParam HashMap<String, String> paramMap, Pageable pageable) {
        List<PostDto> posts = postService.readAllPostList( pageable);
        return ResponseWrapper.ok(posts, "get post list success.");
    }

    @GetMapping("/post-categories/{postCategoryId}/posts")
    public ResponseEntity<ResponseWrapper<List<PostDto>>> getPostList (@PathVariable HashMap<String, String> pathMap, @RequestParam HashMap<String, String> paramMap, Pageable pageable) {
        long postCategoryId = Integer.parseInt(pathMap.get("postCategoryId"));
        List<PostDto> posts = postService.readPostList(postCategoryId, pageable);
        return ResponseWrapper.ok(posts, "get post list success.");
    }

    @PatchMapping("/posts")
    public ResponseEntity<PostDto> patchPostList (){
        /*TODO: For List CUD with Json Patch*/
        // ResponseWrapper.ok(posts, "patch post list success.");
        return null;
    }

    /*Post Post Get Put Delete */
    @PostMapping("/post-categories/{postCategoryId}/posts")
    public ResponseEntity<ResponseWrapper<PostDto>>  postPost ( @RequestBody PostDto requestDto) {
        //with path variable and body and optional param

        PostDto responseDto = postService.createPost(requestDto);

        return ResponseWrapper.created(responseDto, "Create Post Success.");
    }
    @GetMapping("posts/{postId}")
    public ResponseEntity<ResponseWrapper<PostDto>>  getPost (@PathVariable Long postId) {
        //path variable and optional param
        PostDto post = postService.readPost(postId);
        return ResponseWrapper.ok(post, "get post list success.");
    }
    @PutMapping("posts/{postId}")
    public ResponseEntity<PostDto>  putPost (@PathVariable Long postId,  @RequestBody PostDto requestDto) {
        //path variable and body optional param
        postService.updatePost(requestDto);
        return null;
    }
    @DeleteMapping("posts/{postId}")
    public ResponseEntity<PostDto>  deletePost (@PathVariable Long postId) {
        //path variable and optional param
        postService.deletePost(postId);
        return null;
    }
}
