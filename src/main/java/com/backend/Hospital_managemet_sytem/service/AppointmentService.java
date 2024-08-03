package com.backend.Hospital_managemet_sytem.service;

import com.backend.Hospital_managemet_sytem.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    //create appointment
    //get all appointments
    //get appointment by id
    //get appointments by doctor id
    //get appointment by patient id
    //update appointment
    //get appointments by date

//    TODO -> paginate  and also filter by date ,from to

    Appointment createAppointment(Appointment appointment);

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(Long id);

    List<Appointment> getAppointmentsByDoctorId(Long doctorId);

    List<Appointment> getAppointmentsByPatientId(Long patientId);

    Appointment updateAppintment(Appointment appointment);

    List<Appointment> getAppointmentsByDate(LocalDate date);



    
}
