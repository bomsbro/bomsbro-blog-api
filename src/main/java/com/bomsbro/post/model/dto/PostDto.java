package com.bomsbro.post.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Long id;
    private Long postCategoryId;
    private String postCategoryName;
    private Long writerId;
    private String writerName;

    private String title;
    private String content;
    private String previewText;
    private Integer viewCount;
    private Integer replyCount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modifiedDate;

    public PostDto addViewCount(Integer viewCount) {
        this.viewCount = viewCount;
        return this;
    }
    public PostDto addReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
        return this;
    }

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
