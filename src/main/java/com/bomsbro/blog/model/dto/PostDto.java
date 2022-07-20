package com.bomsbro.blog.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long postId;
    private Long boardId;
    private String title;
    private String content;
    private String previewText;
    private String userId;
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
}
