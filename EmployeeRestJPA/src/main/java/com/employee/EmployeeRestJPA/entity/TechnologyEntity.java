package com.employee.EmployeeRestJPA.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "technologies")
public class TechnologyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String version;
    @ManyToMany(mappedBy = "technologies",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ProjectEntity> projects = new ArrayList<>();

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectEntity> projects) {
        this.projects = projects;
    }

    public TechnologyEntity(Integer id, String name, String version, List<ProjectEntity> projects) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.projects = projects;
    }

    public TechnologyEntity() {
    }

    @Override
    public String toString() {
        return "TechnologyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", projects=" + projects +
                '}';
    }
}
