package com.eliegloire.EmployeeDataManagement.repository;

import com.eliegloire.EmployeeDataManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findByNameIgnoreCase(String name);
    public Employee findByHireDate(LocalDate hireDate);
}
