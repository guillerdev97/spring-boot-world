package com.guillerdev97.SpringBootCourse.service;

import com.guillerdev97.SpringBootCourse.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId);
}
