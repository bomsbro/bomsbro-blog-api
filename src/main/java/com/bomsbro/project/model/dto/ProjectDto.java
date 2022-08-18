package com.bomsbro.project.model.dto;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long projectId;

    private String projectName;

    private String projectDescription;

    private String projectGithubUrl;

    private String projectServiceUrl;
}
