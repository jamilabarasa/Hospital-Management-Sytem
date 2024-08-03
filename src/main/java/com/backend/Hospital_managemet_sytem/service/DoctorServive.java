package com.backend.Hospital_managemet_sytem.service;

import com.backend.Hospital_managemet_sytem.exceptions.ResourceNotFoundException;
import com.backend.Hospital_managemet_sytem.model.Doctor;

import java.util.List;

public interface DoctorServive {
    //create a doctor
    //get doctor by id
    //get all doctors
    //get doctors by department id
    //update doctor details

    Doctor createDoctor(Doctor doctor);

    Doctor getDoctorById(Long id);

    List<Doctor> getDoctors();

    List<Doctor> getDoctorsByDepartmentId(Long departmentId);

    Doctor updateDoctor(Doctor doctor);
}
