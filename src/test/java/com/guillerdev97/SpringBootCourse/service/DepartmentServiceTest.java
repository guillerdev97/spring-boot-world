package com.guillerdev97.SpringBootCourse.service;

import com.guillerdev97.SpringBootCourse.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
    }

    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";

        Department found = departmentService.fetchDepartmentByName(departmentName);
    }
}