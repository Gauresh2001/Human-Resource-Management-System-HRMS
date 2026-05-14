package com.hrms.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hrms.entity.Department;
import com.hrms.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin("*")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    // Add Department
    @PostMapping
    public ResponseEntity<Department> addDepartment(
            @RequestBody Department department) {

        return new ResponseEntity<>(
                departmentService.addDepartment(department),
                HttpStatus.CREATED);
    }

    // Get All Departments
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {

        return ResponseEntity.ok(
                departmentService.getAllDepartments());
    }

    // Get Department By ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                departmentService.getDepartmentById(id));
    }

    // Update Department
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(
            @PathVariable Long id,
            @RequestBody Department department) {

        return ResponseEntity.ok(
                departmentService.updateDepartment(id, department));
    }

    // Delete Department
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(
            @PathVariable Long id) {

        departmentService.deleteDepartment(id);

        return ResponseEntity.ok(
                "Department Deleted Successfully");
    }

}
