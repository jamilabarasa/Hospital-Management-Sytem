package com.backend.Hospital_managemet_sytem.repository;

import com.backend.Hospital_managemet_sytem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
