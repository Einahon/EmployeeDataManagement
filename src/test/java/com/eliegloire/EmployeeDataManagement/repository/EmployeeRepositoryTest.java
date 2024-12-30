package com.eliegloire.EmployeeDataManagement.repository;

import com.eliegloire.EmployeeDataManagement.entity.Employee;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Employee employee =
                Employee.builder()
                        .name("Davo Toto")
                        .salary(BigDecimal.valueOf(100000.00))
                        .hireDate(LocalDate.parse("2024-12-11"))
                        .department("IT")
                        .jobTitle("QA")
                .build();
        entityManager.persist(employee);
    }
    @Test
    @DisplayName("Get data by Employee_Id")
    public void whenfindById_thenReturnEmployee() {
        Employee employee = employeeRepository.findById(1L).get();
        assertEquals("Davo Toto", employee.getName());


    }
}