package com.eliegloire.EmployeeDataManagement.service;

import com.eliegloire.EmployeeDataManagement.entity.Employee;
import com.eliegloire.EmployeeDataManagement.error.EmployeeNotFoundException;
import com.eliegloire.EmployeeDataManagement.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IEmployeeServiceTest {
    @Autowired
    private IEmployeeService employeeService;
    @MockBean
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        Employee employee =
                Employee.builder()
                        .name("Elie Inahon")
                        .department("IT")
                        .jobTitle("Developer")
                        .salary(BigDecimal.valueOf(160000))
                        .hireDate(LocalDate.parse("2025-01-15"))
                        .id(1L)
                        .build();

        Mockito.when(employeeRepository.findByNameIgnoreCase("Elie Inahon"))
                .thenReturn(employee);


    }

    @Test
    @DisplayName("Get data by Employee Name")

    public void whenValidEmployeeName_thenReturnEmployeeFound() throws EmployeeNotFoundException {
        String name = "Elie Inahon";
        Employee found =
                employeeService.fetchEmployeeByName(name);
        assertEquals(name, found.getName());
    }


}