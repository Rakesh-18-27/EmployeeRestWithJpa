package com.employee.EmployeeRestJPA.repository;

import com.employee.EmployeeRestJPA.entity.TechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepo extends JpaRepository<TechnologyEntity,Integer> {
}
