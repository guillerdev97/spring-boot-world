package com.guillerdev97.SpringBootCourse.repository;

import com.guillerdev97.SpringBootCourse.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("SAS")
                .departmentAddress("Gijón")
                .departmentCode("111")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void if_give_department_id_department_found() {
        // given
        // Long departmentId = 1L;

        // when
        Department department = departmentRepository.findById(1L).get();

        // then
        assertEquals(department.getDepartmentName(), "SAS");
    }
}