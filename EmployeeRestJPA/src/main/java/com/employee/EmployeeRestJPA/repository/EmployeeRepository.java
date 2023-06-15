package com.employee.EmployeeRestJPA.repository;

import com.employee.EmployeeRestJPA.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,String> {
    @Query(value = "Select  employee From EmployeeEntity employee WHERE employee.addressEntity.district=:district AND employee.addressEntity.state=:state  ")
    public List<EmployeeEntity> findByDistrictAndState(@Param("district") String district, @Param("state") String state);
}
