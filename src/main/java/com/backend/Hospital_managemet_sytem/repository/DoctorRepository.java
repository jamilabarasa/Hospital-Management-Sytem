package com.backend.Hospital_managemet_sytem.repository;

import com.backend.Hospital_managemet_sytem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    List<Doctor> findAllByDepartmentId(Long departmentId);
}
