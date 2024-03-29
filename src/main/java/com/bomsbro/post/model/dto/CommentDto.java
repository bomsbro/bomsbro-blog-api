package com.bomsbro.post.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long commentId;
    private String commentContent;

    private List<CommentDto> subComments;
    private Long parentReplyId;
    private Long postId;
    private String userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modifiedDate;

    //Request DTO. Get, Delete does not have request body.
    @Setter @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostRequest {
        private String name;
    }

    @Setter @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PutRequest {
        private String name;
    }

    @Setter @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListPatchRequest {
        private String name;
    }
}

