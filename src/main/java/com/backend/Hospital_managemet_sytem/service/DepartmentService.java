package com.backend.Hospital_managemet_sytem.service;

import com.backend.Hospital_managemet_sytem.model.Department;

import java.util.List;

public interface DepartmentService {

    //create department
    //update department
    //get all departments
    //get department by ID

    Department createDepartment(Department department);

    Department updateDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);
}
