package com.employee.EmployeeRestJPA.service;

import com.employee.EmployeeRestJPA.entity.ProjectEntity;
import com.employee.EmployeeRestJPA.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
     String add(EmployeeModel employeeModel);
     EmployeeModel getById(String id);
     void deleteById(String id);

     List<EmployeeModel> getAll();
     List<EmployeeModel> getByDistrictAndState(String district,String state);

     List<EmployeeModel> getEmployeesByProjectName(String name);
     String addProjectToEmployee(Integer projectId,String employeeeId);

     String getProjectByEmployeeId(String id);
}
