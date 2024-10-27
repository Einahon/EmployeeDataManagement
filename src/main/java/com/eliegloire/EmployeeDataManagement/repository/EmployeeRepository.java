package com.eliegloire.EmployeeDataManagement.repository;

import com.eliegloire.EmployeeDataManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
