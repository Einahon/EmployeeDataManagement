package com.eliegloire.EmployeeDataManagement.service;

import com.eliegloire.EmployeeDataManagement.entity.Employee;

import java.util.List;

public interface IEmployeeService {
   public  Employee saveEmployee(Employee employee);

  public List<Employee> fetchEmployee();

    public Employee fetchEmployeeById(Long id);
}
