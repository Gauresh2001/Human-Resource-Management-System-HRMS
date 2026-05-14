package com.hrms.serviceimpl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.entity.Department;
import com.hrms.repository.DepartmentRepository;
import com.hrms.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow();
    }

    @Override
    public Department updateDepartment(Long id, Department department) {

        Department existing = departmentRepository.findById(id).orElseThrow();

        existing.setDepartmentName(department.getDepartmentName());
        existing.setDepartmentCode(department.getDepartmentCode());
        existing.setDescription(department.getDescription());

        return departmentRepository.save(existing);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
