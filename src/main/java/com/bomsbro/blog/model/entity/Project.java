package com.bomsbro.blog.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_post")
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "project_github_url")
    private String projectGithubUrl;

    @Column(name = "project_service_url")
    private String projectServiceUrl;

}
