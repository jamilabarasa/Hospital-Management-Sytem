package com.backend.Hospital_managemet_sytem.repository;

import com.backend.Hospital_managemet_sytem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> findAllByDate(LocalDate date);

    List<Appointment> findAllByPatientId(Long patientId);

    List<Appointment> findAllByDoctorId(Long doctorId);
}
