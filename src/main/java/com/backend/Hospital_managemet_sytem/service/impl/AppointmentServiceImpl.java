package com.backend.Hospital_managemet_sytem.service.impl;

import com.backend.Hospital_managemet_sytem.exceptions.ResourceNotFoundException;
import com.backend.Hospital_managemet_sytem.model.Appointment;
import com.backend.Hospital_managemet_sytem.repository.AppointmentRepository;
import com.backend.Hospital_managemet_sytem.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public Appointment createAppointment(Appointment appointment) {
        log.debug("Request to save appointment {} ", appointment);
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        log.debug("Request to get all appointments");
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments;
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        log.debug("Request to get appointment by ID {}", id);
        //check if it exists
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Appointment does not exist with ID " + id));


        return appointment;
    }

    @Override
    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        log.debug("Request to get appointment by doctorId {}",doctorId);

        //check if it exists
        List<Appointment> appointments = appointmentRepository.findAllByDoctorId(doctorId);


        return appointments;
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        log.debug("Request to get appointment by patientId {}",patientId);

        //check if it exists
        List<Appointment> appointments = appointmentRepository.findAllByPatientId(patientId);


        return appointments;
    }

    @Override
    public Appointment updateAppintment(Appointment appointment) {
        log.debug("Request to update appointment by ID {}", appointment.getId());
        //check if it exists
        Appointment appointment1 = appointmentRepository.findById(appointment.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Appointment does not exist with ID " + appointment.getId()));

        appointment1.setReason(appointment.getReason());
        appointment1.setDate(appointment.getDate());
        appointment1.setDoctorId(appointment.getDoctorId());
        appointment1.setPatientId(appointment.getPatientId());
        appointment1.setTime(appointment.getTime());

        log.debug("About to save updated appointment {}",appointment1);

        return appointmentRepository.save(appointment1);
    }

    @Override
    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        log.debug("Request to get appointment by date {}",date);

        //check if it exists
        List<Appointment> appointments = appointmentRepository.findAllByDate(date);


        return appointments;
    }
}
