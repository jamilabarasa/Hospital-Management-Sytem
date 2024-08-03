package com.backend.Hospital_managemet_sytem.service.impl;

import com.backend.Hospital_managemet_sytem.exceptions.ResourceNotFoundException;
import com.backend.Hospital_managemet_sytem.model.Prescription;
import com.backend.Hospital_managemet_sytem.repository.PrescriptionRepository;
import com.backend.Hospital_managemet_sytem.service.PrescriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public Prescription createPrescription(Prescription prescription) {
        log.debug("Request to save Prescription {}",prescription);
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription updatePrescription(Prescription prescription) {
        log.debug("Request to update Prescription {}",prescription);
        //check if it exists
        Prescription prescription1 = prescriptionRepository.findById(prescription.getId()).orElseThrow(()->
                new ResourceNotFoundException("Prescription not found with ID "+prescription.getId()));

        prescription1.setMedication(prescription.getMedication());
        prescription1.setDosage(prescription.getDosage());
        prescription1.setNotes(prescription.getNotes());
        prescription1.setMedication(prescription.getMedication());

        log.debug("About to save updated prescription {}",prescription1);

        return prescriptionRepository.save(prescription1);
    }

    @Override
    public List<Prescription> getPrescriptionByDoctorId(long doctorId) {
        log.debug("About to get prescription by doctor Id {}",doctorId);

        List<Prescription> prescriptions = prescriptionRepository.findAllByDoctorId(doctorId);
        return prescriptions;
    }

    @Override
    public List<Prescription> getPrescriptionByPatientId(long patientId) {
        log.debug("About to get prescription by patient Id {}",patientId);

        List<Prescription> prescriptions = prescriptionRepository.findAllByPatientId(patientId);
        return prescriptions;
    }

    @Override
    public List<Prescription> getPrescriptionByAppointmentId(long appointmentId) {
        log.debug("About to get prescription by appointment Id {}",appointmentId);

        List<Prescription> prescriptions = prescriptionRepository.findAllByAppointmentId(appointmentId);
        return prescriptions;
    }
}
