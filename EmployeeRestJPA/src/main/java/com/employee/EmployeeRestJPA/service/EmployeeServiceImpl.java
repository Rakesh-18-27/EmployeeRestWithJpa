package com.employee.EmployeeRestJPA.service;

import com.employee.EmployeeRestJPA.entity.AddressEntity;
import com.employee.EmployeeRestJPA.entity.EmployeeEntity;
import com.employee.EmployeeRestJPA.entity.ProjectEntity;
import com.employee.EmployeeRestJPA.exception.EmployeesNotFoundException;
import com.employee.EmployeeRestJPA.model.AddressModel;
import com.employee.EmployeeRestJPA.model.EmployeeModel;
import com.employee.EmployeeRestJPA.repository.EmployeeRepository;
import com.employee.EmployeeRestJPA.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public String add(EmployeeModel employeeModel) {
        String orgName = "EMP" + (employeeRepository.count() + 1);
        AddressModel addressModel = employeeModel.getAddressModel();
        EmployeeEntity employeeEntity = employeeRepository.save(new EmployeeEntity(orgName, employeeModel.getName(), employeeModel.getRole(), employeeModel.getSalary(), new AddressEntity(addressModel.getHouseNo(), addressModel.getDistrict(), addressModel.getState())));
        return employeeEntity == null ? "Employee insertion Failed" : "Employee Insertion Successfully";
    }

    @Override
    public EmployeeModel getById(String id) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
        AddressModel addressModel = new ModelMapper().map(employeeEntity.getAddressEntity(), AddressModel.class);
        EmployeeModel employeeModel = new EmployeeModel(addressModel);
        employeeModel.setId(id);
        employeeModel.setProjectEntities(employeeEntity.getProjectEntity());
        new ModelMapper().map(employeeEntity, employeeModel);
        return employeeModel;
    }

    @Override
    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeModel> getAll() {
        List<EmployeeModel> employeeModels = employeeRepository.findAll().stream().map(employeeEntity -> {
            AddressModel addressModel = new ModelMapper().map(employeeEntity.getAddressEntity(), AddressModel.class);
            EmployeeModel employeeModel = new EmployeeModel(addressModel);
            new ModelMapper().map(employeeEntity, employeeModel);
            return employeeModel;
        }).toList();
        if (employeeModels.isEmpty()) {
            throw new EmployeesNotFoundException("Employees are not registered yet.");
        } else {
            return employeeModels;
        }
    }

    @Override
    public List<EmployeeModel> getByDistrictAndState(String district, String state) {
        List<EmployeeEntity> employeeEntities = employeeRepository.findByDistrictAndState(district, state);

        List<EmployeeModel> employeeModels = employeeEntities.stream().map(employeeEntity -> {
            AddressModel addressModel = new ModelMapper().map(employeeEntity.getAddressEntity(), AddressModel.class);
            EmployeeModel employeeModel = new EmployeeModel(addressModel);
            new ModelMapper().map(employeeEntity, employeeModel);
            return employeeModel;
        }).toList();
        if (employeeModels.isEmpty()) {
            throw new EmployeesNotFoundException("Employees are not registered yet.");
        } else {
            return employeeModels;
        }

    }

    @Override
    public List<EmployeeModel> getEmployeesByProjectName(String name) {
ProjectEntity projectEntity=projectRepository.findByName(name);
List<EmployeeEntity> employeeEntities= projectEntity.getEmployeeEntities();
List<EmployeeModel> employeeModels=employeeEntities.stream().map(employeeEntity-> {
AddressModel addressModel=new ModelMapper().map(employeeEntity.getAddressEntity(), AddressModel.class);
EmployeeModel employeeModel=new EmployeeModel(addressModel);
new ModelMapper().map(employeeEntity,employeeModel);
    employeeModel.setProjectEntities(employeeEntity.getProjectEntity());
    return  employeeModel;
}).toList();

return  employeeModels;
    }

    @Override
    public String addProjectToEmployee(Integer projectId, String employeeeId) {
        Optional<ProjectEntity> projectEntity=projectRepository.findById(projectId);
        if(projectEntity.isPresent()){
            ProjectEntity projectEntity1=projectEntity.get();
            Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeeId);
            if(employeeEntity.isPresent()){
                EmployeeEntity employee=employeeEntity.get();
                employee.setProjectEntity(projectEntity1);
                employeeRepository.save(employee);
                return "project named "+projectEntity1.getName()+" added to employee named "+employee.getName()+" successfully";
            }

        }
        return null;
    }

    @Override
    public String getProjectByEmployeeId(String id) {
       Optional<EmployeeEntity> employee=employeeRepository.findById(id);
       if(employee.isPresent()){
           EmployeeEntity employeeEntity=employee.get();
           ProjectEntity projectEntity=employeeEntity.getProjectEntity();
           return employeeEntity.getName()+" is working as a "+employeeEntity.getRole()+" in the project "+projectEntity.getName();
       }
       return null;

    }
}
