package com.employee.EmployeeRestJPA.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}")
    private String startingDate;

    private String endingDate;

    private String durationInDays;
    @OneToMany(mappedBy = "projectEntity",fetch = FetchType.LAZY)
    List<EmployeeEntity> employeeEntities=new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "project_technologies",
    joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    @JsonManagedReference
    private List<TechnologyEntity> technologies=new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public String getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(String durationInDays) {
        this.durationInDays = durationInDays;
    }

    public List<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(List<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }

    public List<TechnologyEntity> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<TechnologyEntity> technologies) {
        this.technologies = technologies;
    }

    public ProjectEntity(Integer id, String name, String startingDate, String endingDate, String durationInDays, List<EmployeeEntity> employeeEntities, List<TechnologyEntity> technologies) {
        this.id = id;
        this.name = name;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.durationInDays = durationInDays;
        this.employeeEntities = employeeEntities;
        this.technologies = technologies;
    }

    public ProjectEntity() {
    }

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startingDate='" + startingDate + '\'' +
                ", endingDate='" + endingDate + '\'' +
                ", durationInDays=" + durationInDays +
                ", employeeEntities=" + employeeEntities +
                ", technologies=" + technologies +
                '}';
    }
}
