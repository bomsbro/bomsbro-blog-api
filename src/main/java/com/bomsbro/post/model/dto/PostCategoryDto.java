package com.bomsbro.post.model.dto;

import com.bomsbro.post.model.entity.PostCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCategoryDto {
    private Long id;
    private String name;
    private Long order;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modifiedDate;

    //Request DTO
    @Setter @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PatchPostCategoryListRequestDto {
        private String name;
    }

    @Setter @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostPostCategoryRequestDto {
        private String name;
    }

    @Setter @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PutPostCategoryRequestDto {
        private String name;
    }
}
