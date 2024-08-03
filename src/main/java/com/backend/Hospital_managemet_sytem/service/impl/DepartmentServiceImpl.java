package com.backend.Hospital_managemet_sytem.service.impl;

import com.backend.Hospital_managemet_sytem.security.exceptions.ResourceNotFoundException;
import com.backend.Hospital_managemet_sytem.model.Department;
import com.backend.Hospital_managemet_sytem.repository.DepartmentRepository;
import com.backend.Hospital_managemet_sytem.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department createDepartment(Department department) {
        log.debug("Request to create department {}",department);
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {

        log.debug("Request to update department with ID {}",department.getId());
        //check if it exists
        Department department1 = departmentRepository.findById(department.getId()).orElseThrow(()->
                new ResourceNotFoundException("Department not found with ID " + department.getId()));

        department1.setName(department.getName());
        department1.setDescription(department.getDescription());
        department1.setHeadId(department.getHeadId());

        log.debug("About to save updated department details {}",department1);

        return departmentRepository.save(department1);
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    @Override
    public Department getDepartmentById(Long id) {
        log.debug("Request to get department by ID {}",id);
        //check if it exists
        Department department = departmentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Department not found with ID " + id));

        return department;
    }
}
