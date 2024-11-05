package com.eliegloire.EmployeeDataManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
   public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Please Employee name is required")
    private String name;
    @NotBlank(message = "Employee department is required")
       private String department;
    @NotBlank(message = "Employee job title is required")
       private String jobTitle;
       @NotNull(message = "Salary is required")
       @Min(value = 100000, message = "Salary must be a minimum of 100000")
       @Max(value = 999999, message = "Salary must be a maximum of 999999")
       private BigDecimal salary;

       private LocalDate hireDate;

       public Long getId() {
           return id;
       }

       public void setId(Long id) {
           this.id = id;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public String getDepartment() {
           return department;
       }

       public void setDepartment(String department) {
           this.department = department;
       }

       public String getJobTitle() {
           return jobTitle;
       }

       public void setJobTitle(String jobTitle) {
           this.jobTitle = jobTitle;
       }

       public @NotNull(message = "Salary is required") @Min(value = 100000, message = "Salary must be a minimum of 100000") @Max(value = 999999, message = "Salary must be a maximum of 999999") BigDecimal getSalary() {
           return salary;
       }

       public void setSalary(BigDecimal salary) {
           this.salary = salary;
       }

       public LocalDate getHireDate() {
           return hireDate;
       }

       public void setHireDate(LocalDate hireDate) {
           this.hireDate = hireDate;
       }

       public Employee(Long id, String name, String department, String jobTitle, BigDecimal salary, LocalDate hireDate) {
           this.id = id;
           this.name = name;
           this.department = department;
           this.jobTitle = jobTitle;
           this.salary = salary;
           this.hireDate = hireDate;
       }
       public Employee(){

       }

       @Override
       public String toString() {
           return "Employee{" +
                   "id=" + id +
                   ", name='" + name + '\'' +
                   ", department='" + department + '\'' +
                   ", jobTitle='" + jobTitle + '\'' +
                   ", salary=" + salary +
                   ", hireDate=" + hireDate +
                   '}';
       }
   }
