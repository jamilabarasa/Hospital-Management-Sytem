package com.backend.Hospital_managemet_sytem.service.impl;

import com.backend.Hospital_managemet_sytem.exceptions.ResourceNotFoundException;
import com.backend.Hospital_managemet_sytem.model.Patient;
import com.backend.Hospital_managemet_sytem.repository.PatientRepository;
import com.backend.Hospital_managemet_sytem.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient createPatient(Patient patient) {
        log.debug("Request to create a patient {}",patient);
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        log.debug("Request to update patient with ID {}",patient.getId());
        //check if patient exits
        Patient patient1 = patientRepository.findById(patient.getId()).orElseThrow(()->
                new ResourceNotFoundException("Patient not found with ID " + patient.getId()));

        patient1.setAddress(patient.getAddress());
        patient1.setGender(patient.getGender());
        patient1.setFirstName(patient.getFirstName());
        patient1.setEmail(patient.getEmail());
        patient1.setDateOfBirth(patient.getDateOfBirth());
        patient1.setPhoneNumber(patient.getPhoneNumber());
        patient1.setMedicalHistory(patient.getMedicalHistory());

        log.debug("About to update patient {}",patient);

        return patientRepository.save(patient1);
    }

    @Override
    public Patient getPatientById(long id) {
        log.debug("Request to find patient by ID {}",id);
        //check if patient exits
        Patient patient = patientRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Patient not found with ID " + id));

        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        log.debug("Request to get all patients");
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

}
