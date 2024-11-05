package com.eliegloire.EmployeeDataManagement.service;

import com.eliegloire.EmployeeDataManagement.entity.Employee;
import com.eliegloire.EmployeeDataManagement.error.EmployeeNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface IEmployeeService {
   public  Employee saveEmployee(Employee employee);

  public List<Employee> fetchEmployee();

    public Employee fetchEmployeeById(Long id) throws EmployeeNotFoundException;

    public Employee updateEmployeeById(Employee employee, Long id);

   public void deleteEmployeeById(Long id);

   public Employee fetchEmployeeByName(String name);

    public Employee fetchByHireDate(LocalDate hireDate);
}
