package com.employee.EmployeeRestJPA.controller;

import com.employee.EmployeeRestJPA.entity.ProjectEntity;
import com.employee.EmployeeRestJPA.model.EmployeeModel;
import com.employee.EmployeeRestJPA.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping("/add-project")
    public ResponseEntity<String> addProject( @RequestBody ProjectEntity projectEntity){
        String result= projectService.addProject(projectEntity);
return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/getProjects")
    public List<ProjectEntity> getProjects(){
    return projectService.getProjects();
    }



}
