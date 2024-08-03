package com.backend.Hospital_managemet_sytem.controller;

import com.backend.Hospital_managemet_sytem.controller.vm.CreatedPatientVM;
import com.backend.Hospital_managemet_sytem.controller.vm.SuccessReponseVM;
import com.backend.Hospital_managemet_sytem.model.Patient;
import com.backend.Hospital_managemet_sytem.model.enumerations.Status;
import com.backend.Hospital_managemet_sytem.service.PatientService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/patients")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<CreatedPatientVM> createPatient(@Valid @RequestBody Patient patient){
        log.debug("REST Request to save patient {}",patient);
        Patient patient1 = patientService.createPatient(patient);
        SuccessReponseVM successReponse = new SuccessReponseVM(
                "Patient Created Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.CREATED.value(),
                System.currentTimeMillis()
        );
        CreatedPatientVM createdPatient = new CreatedPatientVM(
                patient1,
                successReponse
        );

        return new ResponseEntity<>(createdPatient,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CreatedPatientVM> updatePatient(@Valid @RequestBody Patient patient){
        log.debug("REST Request to update patient {}",patient);
        Patient patient1 = patientService.updatePatient(patient);
        SuccessReponseVM successReponse = new SuccessReponseVM(
                "Patient Updated Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.OK.value(),
                System.currentTimeMillis()
        );
        CreatedPatientVM createdPatient = new CreatedPatientVM(
                patient1,
                successReponse
        );

        return new ResponseEntity<>(createdPatient,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients(){
        log.debug("REST Request to get all patients");
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients,HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable long id){
        log.debug("REST Request to get patient by ID {}",id);
        Patient patient = patientService.getPatientById(id);
        return new ResponseEntity<>(patient,HttpStatus.OK);
    }


}
