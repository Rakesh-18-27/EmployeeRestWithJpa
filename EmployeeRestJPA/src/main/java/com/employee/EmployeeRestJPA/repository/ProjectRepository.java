package com.employee.EmployeeRestJPA.repository;

import com.employee.EmployeeRestJPA.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,Integer> {
     ProjectEntity findByName(String name);
}
