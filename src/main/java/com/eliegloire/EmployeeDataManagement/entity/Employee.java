package com.eliegloire.EmployeeDataManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
   public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Please add Employee Name")
    private String name;
       private String department;
       private String jobTitle;

       @Min(value = 100000, message = "Salary must be a minimum of 100000")
       @Max(value = 999999, message = "Salary must be a maximum of 999999")
       private Long salary;

       @NotBlank(message = "Please add hired date")
       private String hireDate;

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

       public Long getSalary() {
           return salary;
       }

       public void setSalary(Long salary) {
           this.salary = salary;
       }

       public String getHireDate() {
           return hireDate;
       }

       public void setHireDate(String hireDate) {
           this.hireDate = hireDate;
       }

       public Employee(Long id, String name, String department, String jobTitle, Long salary, String hireDate) {
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
