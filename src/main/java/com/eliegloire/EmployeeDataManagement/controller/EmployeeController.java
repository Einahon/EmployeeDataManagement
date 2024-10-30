package com.eliegloire.EmployeeDataManagement.controller;

import com.eliegloire.EmployeeDataManagement.entity.Employee;
import com.eliegloire.EmployeeDataManagement.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @GetMapping("/")
    public String helloController(){
        return "Welcome to Employee Data";
    }
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> fetchEmployee(){
        return employeeService.fetchEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long id) {
        return employeeService.fetchEmployeeById(id);
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployeeById(@RequestBody Employee employee, @PathVariable("id") Long id){
        return employeeService.updateEmployeeById(employee, id);
    }
@DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
                return "Employee deleted sucessfully";
    }
    @GetMapping("/employees/name/{name}")
    public Employee fetchEmployeeByName(@PathVariable("name") String name ){
        return employeeService.fetchEmployeeByName(name);
    }

    @GetMapping("/employees/hireDate/{hireDate}")
    public Employee fetchByHireDate(@PathVariable("hireDate") String hireDate){
        return employeeService.fetchByHireDate(hireDate);
    }

}
