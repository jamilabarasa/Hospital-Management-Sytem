package com.backend.Hospital_managemet_sytem.repository;

import com.backend.Hospital_managemet_sytem.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

    List<Prescription> findAllByAppointmentId(long appointmentId);

    List<Prescription> findAllByPatientId(long patientId);

    List<Prescription> findAllByDoctorId(long doctorId);
}
