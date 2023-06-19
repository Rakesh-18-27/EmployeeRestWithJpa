package com.employee.EmployeeRestJPA.service;

import com.employee.EmployeeRestJPA.entity.ProjectEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {
    String addProject( ProjectEntity projectEntity);
    String updateProject(String employeeId, Integer projectId);

    List<ProjectEntity> getProjects();
}