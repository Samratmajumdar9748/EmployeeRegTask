package com.employeereg.emplyeeregapi.Controller;


import com.employeereg.emplyeeregapi.Entity.EmployeeEntity;
import com.employeereg.emplyeeregapi.Models.EmployeeModel;
import com.employeereg.emplyeeregapi.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping(value = {"/addEmployee"})
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeModel employeeModel){

        EmployeeEntity employee= employeeService.createEmployee(employeeModel);
        return new ResponseEntity<>(new EmployeeResponse(employee.getName(),"Employee Created"), HttpStatus.OK);
    }

    @GetMapping(value = {"/getEmployees"})
    public List<EmployeeEntity> getEmployee(){
        return employeeService.getAllEmployees();
    }

    @PutMapping(value = {"/updateEmployee/{empId}"})
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable String empId, @RequestBody EmployeeModel employeeModel){
        EmployeeEntity updatedEntity= new EmployeeEntity( employeeModel.getName(),employeeModel.getDepartment(),Double.parseDouble(employeeModel.getSalary()) );
        updatedEntity=employeeService.updateEmployee(Long.parseLong(empId),updatedEntity);

        return new ResponseEntity<>(new EmployeeResponse( updatedEntity.getName(),"Employee Updated" ),HttpStatus.OK);
    }

    @DeleteMapping(value = {"/deleteEmployee/{empId}"})
    public ResponseEntity<String> deleteEmployee(@PathVariable String empId){
        employeeService.deleteEmployee( Long.parseLong(empId) );
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
