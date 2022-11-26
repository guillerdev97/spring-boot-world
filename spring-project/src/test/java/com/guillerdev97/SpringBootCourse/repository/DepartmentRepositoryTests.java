package com.guillerdev97.SpringBootCourse.repository;

import com.guillerdev97.SpringBootCourse.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DepartmentRepositoryTests {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void testSaveDepartment() {
        // given
        Department department = Department.builder()
                .departmentName("WW-1")
                .departmentAddress("Barcelona")
                .departmentCode("WW")
                .build();

        // when
        Department departmentSaved = departmentRepository.save(department);

        // then
        assertThat(departmentSaved).isNotNull();
        assertThat(departmentSaved.getDepartmentId()).isGreaterThan(0);
    }

}
