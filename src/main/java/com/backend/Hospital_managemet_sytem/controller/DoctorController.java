package com.backend.Hospital_managemet_sytem.controller;

import com.backend.Hospital_managemet_sytem.controller.vm.CreatedDoctorVM;
import com.backend.Hospital_managemet_sytem.controller.vm.SuccessReponseVM;
import com.backend.Hospital_managemet_sytem.model.Doctor;
import com.backend.Hospital_managemet_sytem.model.enumerations.Status;
import com.backend.Hospital_managemet_sytem.service.DoctorServive;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctors")
@Slf4j
public class DoctorController {

    private DoctorServive doctorServive;

    public DoctorController(DoctorServive doctorServive) {
        this.doctorServive = doctorServive;
    }

    @PostMapping
    public ResponseEntity<CreatedDoctorVM> createDoctor(@Valid @RequestBody Doctor doctor) {
        log.debug("REST Request to save doctor");
        Doctor doctor1 = doctorServive.createDoctor(doctor);

        SuccessReponseVM successReponse = new SuccessReponseVM(
                "Doctor Created Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.CREATED.value(),
                System.currentTimeMillis()
        );
        CreatedDoctorVM createdDoctor = new CreatedDoctorVM(
                doctor1,
                successReponse

        );

        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable long id) {
        log.debug("REST Request to get doctor by ID {}", id);
        Doctor doctor = doctorServive.getDoctorById(id);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getDoctors() {
        log.debug("Request to get All doctors");

        List<Doctor> doctors = doctorServive.getDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);

    }

    @GetMapping("/departments/{departmentId}")
    public ResponseEntity<List<Doctor>> getDoctorsByDepartmentId(@PathVariable long departmentId) {
        List<Doctor> doctors = doctorServive.getDoctorsByDepartmentId(departmentId);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CreatedDoctorVM> updateDoctor(@RequestBody Doctor doctor) {

        Doctor doctor1 = doctorServive.updateDoctor(doctor);
        SuccessReponseVM successReponse = new SuccessReponseVM(
                "Doctor Updated Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.OK.value(),
                System.currentTimeMillis()
        );
        CreatedDoctorVM createdDoctor = new CreatedDoctorVM(
                doctor1,
                successReponse

        );
        return new ResponseEntity<>(createdDoctor, HttpStatus.OK);

    }


}
