package com.bomsbro.file.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
    private Long fileId;
    private Long fileName;
    private Long postId;
    private String fileOrgName;
    private String fileExtension;
    private String fileSize;
    private String fileUrl;
}
