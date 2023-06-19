    package com.employee.EmployeeRestJPA.model;

    import com.employee.EmployeeRestJPA.entity.ProjectEntity;
    import jakarta.persistence.OneToOne;
    import jakarta.validation.Valid;
    import jakarta.validation.constraints.NotEmpty;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Positive;

    import java.util.ArrayList;
    import java.util.List;

    public class EmployeeModel {
        private String id;
        @NotEmpty(message = "employee name should not be empty")
        private String name;

        private String role;
        @Positive(message = "salary must be positive")
        private Double salary;

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public ProjectEntity getProjectEntities() {
            return projectEntity;
        }

        public void setProjectEntities(ProjectEntity projectEntities) {
            this.projectEntity = projectEntities;
        }

        @Valid
        private AddressModel addressModel;
       private ProjectEntity projectEntity;

        public EmployeeModel(AddressModel addressModel) {
            this.addressModel=addressModel;
        }

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

        public AddressModel getAddressModel() {
            return addressModel;
        }

        @Override
        public String toString() {
            return "EmployeeModel{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", role='" + role + '\'' +
                    ", salary=" + salary +
                    ", addressModel=" + addressModel +
                    ", projectEntities=" + projectEntity +
                    '}';
        }

        public void setAddressModel(AddressModel addressModel) {
            this.addressModel = addressModel;
        }

        public EmployeeModel(String id, String name, String role, Double salary, AddressModel addressModel, ProjectEntity projectEntity) {
            this.id = id;
            this.name = name;
            this.role = role;
            this.salary = salary;
            this.addressModel = addressModel;
            this.projectEntity = projectEntity;
        }

        public EmployeeModel(String name, Double salary, AddressModel addressModel) {

            this.name = name;
            this.salary = salary;
            this.addressModel = addressModel;
        }
        public EmployeeModel( String id,String name,String role, Double salary, AddressModel addressModel) {
            this.id=id;
            this.name = name;
            this.role=role;
            this.salary = salary;
            this.addressModel = addressModel;
        }
public EmployeeModel(){

}

    }
