package com.employee.EmployeeRestJPA.repository;

import com.employee.EmployeeRestJPA.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,String> {
}
