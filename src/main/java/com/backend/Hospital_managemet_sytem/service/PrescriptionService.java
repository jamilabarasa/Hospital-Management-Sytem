package com.backend.Hospital_managemet_sytem.service;

import com.backend.Hospital_managemet_sytem.model.Prescription;

import java.util.List;

public interface PrescriptionService {

    //create a prescription
    //update a prescription
    //fetch prescription by doctors id
    //fetch prescription by patient id
    //fetch prescription by appointment id

    Prescription createPrescription(Prescription prescription);

    Prescription updatePrescription(Prescription prescription);

    List<Prescription> getPrescriptionByDoctorId(long doctorId);

    List<Prescription> getPrescriptionByPatientId(long patientId);

    List<Prescription> getPrescriptionByAppointmentId(long appointmentId);


}
