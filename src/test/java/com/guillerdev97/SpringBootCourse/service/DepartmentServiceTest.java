package com.guillerdev97.SpringBootCourse.service;

import com.guillerdev97.SpringBootCourse.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    public void if_department_list_is_found

    @Test
    public void givenDepartmentName_thenDepartmentFound() {
        // given
        String departmentName = "A-123";

        // when
        Department departmentFound = departmentService.fetchDepartmentByName(departmentName);

        // then
        assertEquals(departmentName, departmentFound.getDepartmentName());
    }
}