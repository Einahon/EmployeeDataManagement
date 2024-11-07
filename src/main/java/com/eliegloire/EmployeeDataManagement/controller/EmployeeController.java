package com.eliegloire.EmployeeDataManagement.controller;

import com.eliegloire.EmployeeDataManagement.entity.Employee;
import com.eliegloire.EmployeeDataManagement.error.EmployeeNotFoundException;
import com.eliegloire.EmployeeDataManagement.service.impl.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
public class EmployeeController {
    @GetMapping("/")
    public String helloController(){
        return "Welcome to Employee Data";
    }

    @Autowired
    private EmployeeService employeeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody @Valid Employee employee){
        LOGGER.info("Logger for saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> fetchEmployee(){
        LOGGER.info("Logger for fetchEmployee of EmployeeController");
        return employeeService.fetchEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        return employeeService.fetchEmployeeById(id);
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployeeById(@Valid @RequestBody Employee employee, @PathVariable("id") Long id) throws EmployeeNotFoundException {
        return employeeService.updateEmployeeById(employee, id);
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        employeeService.deleteEmployeeById(id);
                return "Employee deleted successfully";
    }
    @GetMapping("/employees/name/{name}")
    public Employee fetchEmployeeByName(@PathVariable("name") String name ) throws EmployeeNotFoundException {
        return employeeService.fetchEmployeeByName(name);
    }

    @GetMapping("/employees/hireDate/{hireDate}")
    public Employee fetchByHireDate(@PathVariable("hireDate") LocalDate hireDate) throws EmployeeNotFoundException {
        return employeeService.fetchByHireDate(hireDate);
    }

}
