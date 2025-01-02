package com.eliegloire.EmployeeDataManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Please Add Name")
       private String name;
       private String department;
       private String jobTitle;
       private BigDecimal salary;
       private LocalDate hireDate;


   }
