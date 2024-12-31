package com.eliegloire.EmployeeDataManagement.controller;

import com.eliegloire.EmployeeDataManagement.entity.Employee;
import com.eliegloire.EmployeeDataManagement.error.EmployeeNotFoundException;
import com.eliegloire.EmployeeDataManagement.service.impl.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .hireDate(LocalDate.parse("2024-03-25"))
                .salary(BigDecimal.valueOf(175000.00))
                .name("Auree Chris")
                .department("IT")
                .jobTitle("Scrum Master")
                .id(1L)
                .build();
    }

    @Test
    @DisplayName("Test by saveEmployee endpoint")
    void saveEmployee() throws Exception {
        Employee inputEmployee = Employee.builder()
                .hireDate(LocalDate.parse("2024-03-25"))
                .salary(BigDecimal.valueOf(175000.00))
                .name("Auree Chris")
                .department("IT")
                .jobTitle("Scrum Master")
                .build();

        Mockito.when(employeeService.saveEmployee(inputEmployee))
                .thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{  \"name\": \"Auree Chris\",\n" +
                        "\t\t\"department\": \"IT\",\n" +
                        "\t\t\"jobTitle\": \"Scrum Master\",\n" +
                        "\t\t\"salary\": 175000.00,\n" +
                        "\t\t\"hireDate\": \"2024-03-25\"\n" +
                        "\n" +
                        "\t}\n"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Test by fetchEmployeeById endpoint")
    void fetchEmployeeById() throws Exception {
        Employee inEmployee = Employee.builder()
                .hireDate(LocalDate.parse("2024-03-25"))
                .salary(BigDecimal.valueOf(175000.00))
                .name("Auree Chris")
                .department("IT")
                .jobTitle("Scrum Master")
                        .build();

        Mockito.when(employeeService.fetchEmployeeById(1L))
                .thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.get("/employees/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}