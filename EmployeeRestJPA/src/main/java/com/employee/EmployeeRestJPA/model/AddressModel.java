package com.employee.EmployeeRestJPA.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;

@Validated
public class AddressModel {
    @NotEmpty(message = "house number cannot be empty")
    @Pattern(regexp = "^[0-9-/A-Za-z]+$",message = "please enter valid house number")
    private String houseNo;
    @NotEmpty(message = "distict name cannot be empty")
    private String district;
    @NotEmpty(message = "state name cannot be empty")
    private String state;

    public AddressModel() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNo='" + houseNo + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public AddressModel(String houseNo, String district, String state) {
        this.houseNo = houseNo;
        this.district = district;
        this.state = state;
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



}
