package com.bomsbro.post.controller;

import com.bomsbro.global.model.dto.ResponseWrapper;
import com.bomsbro.post.model.dto.CommentDto;
import com.bomsbro.post.model.entity.Comment;
import com.bomsbro.post.model.mapper.CommentMapper;
import com.bomsbro.post.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/post-categories/{postCategoryId}/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {
    //TODO: Controller 에서 Dto<->Entity 전환
    //TODO: DtoWrapper? ResponseEntity? 로 감싸서 response
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    /*CommentList Get Patch*/
    @GetMapping("")
    public ResponseEntity<ResponseWrapper<List<CommentDto>>> getCommentList (@RequestParam HashMap<String, String> paramMap, SpringDataWebProperties.Pageable pageable) {
        List<CommentDto> comments = commentMapper.convertEntityListToDto(commentService.readCommentList());
        return ResponseWrapper.ok(comments, "get post list success.");
    }

    @PatchMapping("")
    public  ResponseEntity<CommentDto> patchCommentList (){
        /*TODO: For List CUD with Json Patch*/
        // ResponseWrapper.ok(comments, "patch post list success.");
        return null;
    }

    /*Comment Post Get Put Delete */
    @PostMapping("")
    public ResponseEntity<ResponseWrapper<CommentDto>>  postComment ( @RequestBody CommentDto requestDto) {
        //with path variable and body and optional param
        Comment comment = commentMapper.convertToEntity(requestDto);
        CommentDto responseDto = commentMapper.convertToDto(commentService.createComment(comment));

        return ResponseWrapper.created(responseDto, "Create Comment Success.");
    }
    @GetMapping("/{commentId}")
    public ResponseEntity<ResponseWrapper<CommentDto>>  getComment (@PathVariable Long commentId) {
        //path variable and optional param
        CommentDto comment = commentMapper.convertToDto(commentService.readComment(commentId));
        return ResponseWrapper.ok(comment, "get post list success.");
    }
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto>  putComment (@PathVariable Long commentId, @RequestBody CommentDto requestDto) {
        //path variable and body optional param
        Comment comment = commentMapper.convertToEntity(requestDto);
        commentService.updateComment(comment);
        return null;
    }
    @DeleteMapping("/{commentId}")
    public ResponseEntity<CommentDto>  deleteComment (@PathVariable Long commentId) {
        //path variable and optional param
        commentService.deleteComment(commentId);
        return null;
    }
}
