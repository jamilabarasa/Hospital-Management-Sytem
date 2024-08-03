package com.backend.Hospital_managemet_sytem.controller;

import com.backend.Hospital_managemet_sytem.controller.vm.CreatedAppointmentVM;
import com.backend.Hospital_managemet_sytem.controller.vm.SuccessReponseVM;
import com.backend.Hospital_managemet_sytem.model.Appointment;
import com.backend.Hospital_managemet_sytem.model.enumerations.Status;
import com.backend.Hospital_managemet_sytem.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<CreatedAppointmentVM> createAppointment(@Valid @RequestBody Appointment appointment){
        log.debug("REST Request to save appointment {}",appointment);
        Appointment appointment1 = appointmentService.createAppointment(appointment);

        SuccessReponseVM successReponse = new SuccessReponseVM(
                "Appointment Created Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.CREATED.value(),
                System.currentTimeMillis()
        );
        CreatedAppointmentVM createdAppointment = new CreatedAppointmentVM(
                appointment1,
                successReponse
        );
        return  new ResponseEntity<>(createdAppointment,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CreatedAppointmentVM> updateAppointment(@Valid @RequestBody Appointment appointment){
        log.debug("REST Request to update appointment {}",appointment);
        Appointment appointment1 = appointmentService.updateAppintment(appointment);

        SuccessReponseVM successReponse = new SuccessReponseVM(
                "Appointment Updated Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.OK.value(),
                System.currentTimeMillis()
        );
        CreatedAppointmentVM createdAppointment = new CreatedAppointmentVM(
                appointment1,
                successReponse
        );
        return  new ResponseEntity<>(createdAppointment,HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        log.debug("REST Request to get all appointments");
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return new ResponseEntity<>(appointments,HttpStatus.OK);
    }

    @GetMapping("/{doctorId}/doctor")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(@PathVariable long doctorId){
        log.debug("REST Request to get all appointments by doctor ID {}",doctorId);
        List<Appointment> appointments = appointmentService.getAppointmentsByDoctorId(doctorId);
        return new ResponseEntity<>(appointments,HttpStatus.OK);
    }

    @GetMapping("/{patientId}/patient")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable long patientId){
        log.debug("REST Request to get all appointments by patient ID {}",patientId);
        List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(patientId);
        return new ResponseEntity<>(appointments,HttpStatus.OK);
    }

    @GetMapping("/{date}/date")
    public ResponseEntity<List<Appointment>> getAppointmentsByDate(@PathVariable LocalDate date){
        log.debug("REST Request to get all appointments by date  {}",date);
        List<Appointment> appointments = appointmentService.getAppointmentsByDate(date);
        return new ResponseEntity<>(appointments,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentId(@PathVariable long id){
        log.debug("REST Request to get appointments by ID {}",id);
        Appointment appointment = appointmentService.getAppointmentById(id);
        return new ResponseEntity<>(appointment,HttpStatus.OK);
    }





}
