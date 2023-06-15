package com.employee.EmployeeRestJPA.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    private String id;
    private String name;
    private Double salary;
    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity addressEntity;

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
                ", salary=" + salary +
                ", addressEntity=" + addressEntity +
                '}';
    }

    public EmployeeEntity(String id, String name, Double salary, AddressEntity addressEntity) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.addressEntity = addressEntity;
    }
}
