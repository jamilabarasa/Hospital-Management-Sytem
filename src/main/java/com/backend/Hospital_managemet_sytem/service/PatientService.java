package com.backend.Hospital_managemet_sytem.service;

import com.backend.Hospital_managemet_sytem.model.Patient;

import java.util.List;

public interface PatientService {
    //create patient
    //update patient
    //get patient by id
    //get all patients

    Patient createPatient(Patient patient);

    Patient updatePatient(Patient patient);

    Patient getPatientById(long id);

    List<Patient> getAllPatients();

//    TODO -> save patient medical history to a diffrent table
}
