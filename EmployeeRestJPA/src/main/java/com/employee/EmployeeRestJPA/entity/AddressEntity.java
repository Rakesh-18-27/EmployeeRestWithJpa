package com.employee.EmployeeRestJPA.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String houseNo;
    private String district;
    private String state;
    @OneToOne(mappedBy = "addressEntity")
    private EmployeeEntity employeeEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public AddressEntity( String houseNo, String district, String state) {
        this.houseNo = houseNo;
        this.district = district;
        this.state = state;
    }

    public AddressEntity() {
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id='" + id + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
