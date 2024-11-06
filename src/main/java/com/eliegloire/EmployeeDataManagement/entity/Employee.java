package com.eliegloire.EmployeeDataManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


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


   }
