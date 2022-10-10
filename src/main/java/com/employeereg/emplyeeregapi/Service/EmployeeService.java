package com.employeereg.emplyeeregapi.Service;

import com.employeereg.emplyeeregapi.Entity.EmployeeEntity;
import com.employeereg.emplyeeregapi.Models.EmployeeModel;
import com.employeereg.emplyeeregapi.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    /**
     * -Create Employee
     * -Employee Update
     * -Employee Delete
     * -Employee Lis
     */

    EmployeeRepo employeeRepo;

    @Autowired
    EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;
    }

    public EmployeeEntity createEmployee( EmployeeModel employeeModel ){
        EmployeeEntity employeeEntity= new EmployeeEntity( employeeModel.getName(),employeeModel.getDepartment(), Double.parseDouble(employeeModel.getSalary()) );
        return employeeRepo.save(employeeEntity);
    }

    public EmployeeEntity updateEmployee(long id, EmployeeEntity employeeEntity){
        Optional<EmployeeEntity> found= employeeRepo.findById(id);
        if (found.isPresent()){
            EmployeeEntity newEmployee= found.get();
            newEmployee.setDepartment(employeeEntity.getDepartment());
            newEmployee.setName(employeeEntity.getName());
            newEmployee.setSalary(employeeEntity.getSalary());
            return employeeRepo.save(newEmployee);
        }
        else return null;
    }

    public void deleteEmployee(long id){
        EmployeeEntity employee= employeeRepo.findById(id).get();
        if ( employee!=null ){
            employeeRepo.delete(employee);
        }
        else {
            //do nothing for now
        }
    }

    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepo.findAll();
    }

}
