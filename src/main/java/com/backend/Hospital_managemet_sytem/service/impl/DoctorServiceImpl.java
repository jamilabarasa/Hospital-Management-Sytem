package com.backend.Hospital_managemet_sytem.service.impl;

import com.backend.Hospital_managemet_sytem.security.exceptions.ResourceNotFoundException;
import com.backend.Hospital_managemet_sytem.model.Doctor;
import com.backend.Hospital_managemet_sytem.repository.DoctorRepository;
import com.backend.Hospital_managemet_sytem.service.DoctorServive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DoctorServiceImpl implements DoctorServive {

    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        log.debug("Request to save doctor {}",doctor);
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorById(Long id){
        log.debug("Request to get doctor by ID {}",id);
        //check if doctor exists
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Doctor does not exist with ID " + id));

        return doctor;
    }

    @Override
    public List<Doctor> getDoctors() {
        log.debug("Request to get all doctors");
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors;
    }

    @Override
    public List<Doctor> getDoctorsByDepartmentId(Long departmentId) {
        log.debug("Request to get all doctors by department ID {}",departmentId);
        List<Doctor> doctors = doctorRepository.findAllByDepartmentId(departmentId);
        return doctors;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        log.debug("Request to update doctor with ID {}",doctor.getId());

        //check if doctor exists
        Doctor doctor1 = doctorRepository.findById(doctor.getId()).orElseThrow(()->
                new ResourceNotFoundException("Doctor Not found with ID " + doctor.getId()));

        //SET the fields we want to update
        doctor1.setFirstName(doctor.getFirstName());
        doctor1.setLastName(doctor.getLastName());
        doctor1.setEmail(doctor.getEmail());
        doctor1.setExperience(doctor.getExperience());
        doctor1.setEmail(doctor.getEmail());

        log.debug("About to save updated Doctore {}",doctor1);

        return doctorRepository.save(doctor1);
    }
}
