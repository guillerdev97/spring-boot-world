package com.guillerdev97.SpringBootCourse.controller;

import com.guillerdev97.SpringBootCourse.entity.Department;
import com.guillerdev97.SpringBootCourse.error.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    // private final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public ResponseEntity<Object> saveDepartment(@Valid @RequestBody Department department) {
        // log.info("saveDepartment DepartmentController");
        Department responseDepartment = departmentService.saveDepartment(department);

        Map<String, Object> bodyResponse = new HashMap<String, Object>();
        bodyResponse.put("message", "Department has been created");
        bodyResponse.put("data", responseDepartment);

        return ResponseEntity.status(201).body(bodyResponse);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);

        return "Department has been deleted";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
