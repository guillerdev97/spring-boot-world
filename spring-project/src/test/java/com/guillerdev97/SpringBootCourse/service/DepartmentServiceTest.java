package com.guillerdev97.SpringBootCourse.service;

import com.guillerdev97.SpringBootCourse.entity.Department;
import com.guillerdev97.SpringBootCourse.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("SAS")
                .departmentAddress("Gijón")
                .departmentCode("111")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("SAS"))
                .thenReturn(department);
    }


    @Test
    public void if_given_department_name_department_found() {
        // given
        String departmentName = "SAS";

        // when
        Department departmentFound = departmentService.fetchDepartmentByName(departmentName);

        // then
        assertEquals(departmentName, departmentFound.getDepartmentName());
    }
}