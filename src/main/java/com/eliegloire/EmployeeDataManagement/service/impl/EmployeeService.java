package com.eliegloire.EmployeeDataManagement.service.impl;

import com.eliegloire.EmployeeDataManagement.entity.Employee;
import com.eliegloire.EmployeeDataManagement.error.EmployeeNotFoundException;
import com.eliegloire.EmployeeDataManagement.repository.EmployeeRepository;
import com.eliegloire.EmployeeDataManagement.service.IEmployeeService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(!employee.isPresent()){
            throw new EmployeeNotFoundException("Employee not available at the id "+ id);
        }
        return employee.get();
    }

    @Override
    public Employee updateEmployeeById(Employee employee, Long id) {
        Employee employee1 = employeeRepository.findById(id).get();
        if(Objects.nonNull(employee.getName()) &&
                !"".equalsIgnoreCase(employee.getName())) {
            employee1.setName(employee.getName());
        }

        if((employee.getSalary()!= null) &&
                !"".equalsIgnoreCase(String.valueOf(employee.getSalary()))){
            employee1.setSalary(employee.getSalary());
        }

        if(Objects.nonNull(employee.getDepartment())&&
                !"".equalsIgnoreCase(employee.getDepartment())){
            employee1.setDepartment(employee.getDepartment());
        }

        if(Objects.nonNull(employee.getJobTitle())&&
                !"".equalsIgnoreCase(employee.getJobTitle())){
            employee1.setJobTitle(employee.getJobTitle());
        }

        if(employee.getHireDate() != null){
            employee1.setHireDate(employee.getHireDate());

        }

        return employeeRepository.save(employee1);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee fetchEmployeeByName(String name) {
        return employeeRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Employee fetchByHireDate(LocalDate hireDate) {
        return employeeRepository.findByHireDate(hireDate);
    }

}

