package com.guillerdev97.SpringBootCourse.controller;

import com.guillerdev97.SpringBootCourse.entity.Department;
import com.guillerdev97.SpringBootCourse.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments/create")
    public Department saveDepartment(@RequestBody  Department department) {
        return departmentService.saveDepartment(department);
    }
}
