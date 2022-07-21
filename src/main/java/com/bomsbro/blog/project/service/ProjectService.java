package com.bomsbro.blog.project.service;

import java.util.List;
import com.bomsbro.blog.project.model.entity.Project;


public interface ProjectService {

    /*Project List CRUD*/
    public List<Project> readProjectList();
    //parameter 없으면 모든 리스트 리턴, parameter 있으면 골라서 읽음
    public int updateProjectList();
    //id 리스트만 받으면 deleteList,  id와 다른 컬럼들을 함께 받으면 해당 컬럼 update

    /*Project CRUD*/
    public void createProject();
    public Project readProject();
    public int updateProject();
    public int deleteProject();
}
