package com.backend.Hospital_managemet_sytem.controller;

import com.backend.Hospital_managemet_sytem.controller.vm.CreatedPrescriptionVM;
import com.backend.Hospital_managemet_sytem.controller.vm.SuccessReponseVM;
import com.backend.Hospital_managemet_sytem.model.Prescription;
import com.backend.Hospital_managemet_sytem.model.enumerations.Status;
import com.backend.Hospital_managemet_sytem.service.PrescriptionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/prescription")
public class PrescriptionController {

    private PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    public ResponseEntity<CreatedPrescriptionVM> createPrescription(@Valid @RequestBody Prescription prescription){
        log.debug("REST Request to save prescription {}",prescription);
        Prescription prescription1  = prescriptionService.createPrescription(prescription);

        SuccessReponseVM successReponse = new SuccessReponseVM(
                "Prescription Created Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.CREATED.value(),
                System.currentTimeMillis()
        );
        CreatedPrescriptionVM createdPrescription = new CreatedPrescriptionVM(
                prescription1,
                successReponse
        );
        return  new ResponseEntity<>(createdPrescription,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CreatedPrescriptionVM> updatePrescription(@Valid @RequestBody Prescription prescription){
        log.debug("REST Request to update prescription {}",prescription);
        Prescription prescription1  = prescriptionService.updatePrescription(prescription);

        SuccessReponseVM successReponse = new SuccessReponseVM(
                "Prescription Updated Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.OK.value(),
                System.currentTimeMillis()
        );
        CreatedPrescriptionVM createdPrescription = new CreatedPrescriptionVM(
                prescription1,
                successReponse
        );
        return  new ResponseEntity<>(createdPrescription,HttpStatus.OK);
    }

    @GetMapping("/{patientId}/patient")
    public ResponseEntity<List<Prescription>> getPrescriptionsByPatientId(@PathVariable long patientId){
        log.debug("REST Request to get all Prescriptions by patient ID {}",patientId);
        List<Prescription> prescriptions = prescriptionService.getPrescriptionByPatientId(patientId);
        return new ResponseEntity<>(prescriptions,HttpStatus.OK);
    }

    @GetMapping("/{doctorId}/doctor")
    public ResponseEntity<List<Prescription>> getPrescriptionsByDoctorId(@PathVariable long doctorId){
        log.debug("REST Request to get all Prescriptions by doctor ID {}",doctorId);
        List<Prescription> prescriptions = prescriptionService.getPrescriptionByDoctorId(doctorId);
        return new ResponseEntity<>(prescriptions,HttpStatus.OK);
    }

    @GetMapping("/{appointmentId}/appointment")
    public ResponseEntity<List<Prescription>> getPrescriptionsByAppointmentId(@PathVariable long appointmentId){
        log.debug("REST Request to get all Prescriptions by appointment ID {}",appointmentId);
        List<Prescription> prescriptions = prescriptionService.getPrescriptionByAppointmentId(appointmentId);
        return new ResponseEntity<>(prescriptions,HttpStatus.OK);
    }
}
