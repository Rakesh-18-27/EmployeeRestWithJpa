    package com.employee.EmployeeRestJPA.model;

    import jakarta.persistence.OneToOne;
    import jakarta.validation.Valid;
    import jakarta.validation.constraints.NotEmpty;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Positive;

    public class EmployeeModel {
        private String id;
        @NotEmpty(message = "employee name should not be empty")
        private String name;
        @Positive(message = "salary must be positive")
        private Double salary;
        @Valid
        private AddressModel addressModel;

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
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", address=" + addressModel +
                    '}';
        }

        public void setAddressModel(AddressModel addressModel) {
            this.addressModel = addressModel;
        }
        public EmployeeModel( String name, Double salary, AddressModel addressModel) {

            this.name = name;
            this.salary = salary;
            this.addressModel = addressModel;
        }
        public EmployeeModel( String id,String name, Double salary, AddressModel addressModel) {
            this.id=id;
            this.name = name;
            this.salary = salary;
            this.addressModel = addressModel;
        }
public EmployeeModel(){

}

    }
