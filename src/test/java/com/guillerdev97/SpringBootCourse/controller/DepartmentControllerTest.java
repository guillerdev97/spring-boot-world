package com.guillerdev97.SpringBootCourse.controller;

import com.guillerdev97.SpringBootCourse.entity.Department;
import com.guillerdev97.SpringBootCourse.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentId(1L)
                .departmentName("SS")
                .departmentAddress("Ribadesella")
                .departmentCode("01")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("SS")
                .departmentAddress("Ribadesella")
                .departmentCode("01")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\": \"SS\",\n" +
                        "    \"departmentAddress\": \"Ribadesella\",\n" +
                        "    \"departmentCode\": \"01\"\n" +
                        "}"))
                .andExpect(status().is(201));
    }

    @Test
    void fetchDepartmentById() {
    }
}