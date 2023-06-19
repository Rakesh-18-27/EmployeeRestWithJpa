package com.employee.EmployeeRestJPA.controller;

import com.employee.EmployeeRestJPA.entity.ProjectEntity;
import com.employee.EmployeeRestJPA.model.EmployeeModel;
import com.employee.EmployeeRestJPA.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody EmployeeModel employeeModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.add(employeeModel));
    }

    @GetMapping("/get-by-id/{id}")
    public EmployeeModel getById(@PathVariable String id) {

        return employeeService.getById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public void deleteById(@PathVariable String id) {

        employeeService.deleteById(id);
    }

    @GetMapping("/getAll")
    public List<EmployeeModel> getAll() {

        return employeeService.getAll();
    }
    @GetMapping("/get-by-district-and-state/{state}/{district}")
    public List<EmployeeModel> getByDistrictAndState(@PathVariable String state,@PathVariable String district){
        return employeeService.getByDistrictAndState(district, state);
    }

    @GetMapping("/get-employees-by-projectname/{name}")
    public List<EmployeeModel> getEmployeesByProject(@PathVariable String name){
return employeeService.getEmployeesByProjectName(name);
    }

    @PutMapping("add-project-to-employee/{projectId}/{employeeId}")
    public ResponseEntity<String> addprojectToEmployee(@PathVariable Integer projectId,@PathVariable String employeeId  ){
        String result=employeeService.addProjectToEmployee(projectId, employeeId);
return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

    @GetMapping("/get-project-by-employeeId/{id}")
    public ResponseEntity<String> getProjectByEmployeeId(@PathVariable String id){
         String result=employeeService.getProjectByEmployeeId(id);
         return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
