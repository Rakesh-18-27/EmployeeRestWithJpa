package com.employee.EmployeeRestJPA.service;

import com.employee.EmployeeRestJPA.entity.EmployeeEntity;
import com.employee.EmployeeRestJPA.entity.ProjectEntity;
import com.employee.EmployeeRestJPA.exception.EmployeeNotFoundException;
import com.employee.EmployeeRestJPA.repository.EmployeeRepository;
import com.employee.EmployeeRestJPA.repository.ProjectRepository;
import com.employee.EmployeeRestJPA.utility.ProjectUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public String addProject(String id, ProjectEntity projectEntity) {
        String startDate=projectEntity.getStartingDate();
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateStarting=LocalDate.parse(startDate,dateTimeFormatter);
        String endDate=projectEntity.getEndingDate();
        if(ProjectUtility.isDate(endDate)){
            LocalDate dateEnding=LocalDate.parse(endDate,dateTimeFormatter);
            Period duration=Period.between(dateStarting,dateEnding);
            String durationPeriod=duration.getYears()+" years "+duration.getMonths()+" months "+duration.getDays()+" days ";
            projectEntity.setDurationInDays(durationPeriod);
        }else{
            Period duration=Period.between(dateStarting,LocalDate.now());
            String durationPeriod=duration.getYears()+" years "+duration.getMonths()+" months "+duration.getDays()+" days ";
            projectEntity.setDurationInDays(durationPeriod);
        }


        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(id);
        if(employeeEntity.isPresent()){
            EmployeeEntity employee=employeeEntity.get();
            employee.setProjectEntities(projectEntity);
            EmployeeEntity updatedEmployee=employeeRepository.save(employee);
            return "Project Added Successfully to :"+employee.getName();

        }
        return null;
    }

    @Override
    public String updateProject(String employeeId, Integer projectId) {
        return null;
    }

    @Override
    public List<ProjectEntity> getProjects() {
        return projectRepository.findAll();
    }
}
