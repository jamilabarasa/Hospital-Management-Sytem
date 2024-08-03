package com.backend.Hospital_managemet_sytem.controller;

import com.backend.Hospital_managemet_sytem.controller.vm.CreatedDepartmentVM;
import com.backend.Hospital_managemet_sytem.controller.vm.SuccessReponseVM;
import com.backend.Hospital_managemet_sytem.model.Department;
import com.backend.Hospital_managemet_sytem.model.enumerations.Status;
import com.backend.Hospital_managemet_sytem.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<CreatedDepartmentVM> createDepartment(@Valid @RequestBody Department department){
        log.debug("REST Request to save department {}",department);
        Department department1 = departmentService.createDepartment(department);
        SuccessReponseVM successReponse = new SuccessReponseVM(
                "Department Created Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.CREATED.value(),
                System.currentTimeMillis()
        );
        CreatedDepartmentVM createdDepartment = new CreatedDepartmentVM(
                department1,
                successReponse
        );
        return  new ResponseEntity<>(createdDepartment,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<CreatedDepartmentVM> updateDepartment(@Valid @RequestBody Department department){
        log.debug("REST Request to update department with ID {}",department.getId());
        Department department1 = departmentService.updateDepartment(department);
        SuccessReponseVM successReponse = new SuccessReponseVM(
                "Department Updated Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.OK.value(),
                System.currentTimeMillis()
        );
        CreatedDepartmentVM createdDepartment = new CreatedDepartmentVM(
                department1,
                successReponse
        );
        return  new ResponseEntity<>(createdDepartment,HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Department>> getAlldepartments(){
        log.debug("REST Request to get all departments");
        List<Department>  departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable long id){
        log.debug("REST Request to get deparment by ID {}",id);
        Department department = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }
}
