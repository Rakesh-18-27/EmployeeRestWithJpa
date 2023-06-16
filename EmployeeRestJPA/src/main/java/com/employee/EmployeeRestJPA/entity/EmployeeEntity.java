package com.employee.EmployeeRestJPA.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    private String id;
    private String name;

    private String role;
    private Double salary;
    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity addressEntity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private ProjectEntity projectEntity;

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Double getSalary() {

        return salary;
    }

    public void setSalary(Double salary) {

        this.salary = salary;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ProjectEntity getProjectEntities() {
        return projectEntity;
    }

    public void setProjectEntities(ProjectEntity projectEntity) {
        this.projectEntity = projectEntity;
    }

    public AddressEntity getAddressEntity() {

        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {

        this.addressEntity = addressEntity;
    }

    public EmployeeEntity() {

    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", addressEntity=" + addressEntity +
                ", projectEntities=" + projectEntity +
                '}';
    }

    public EmployeeEntity(String id, String name, String role,Double salary, AddressEntity addressEntity) {
        this.id = id;
        this.name = name;
        this.role=role;
        this.salary = salary;
        this.addressEntity = addressEntity;
    }
    public EmployeeEntity(String id, String name, String role, Double salary, AddressEntity addressEntity, ProjectEntity projectEntity) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.addressEntity = addressEntity;
        this.projectEntity = projectEntity;
    }
}
