package com.backend.Hospital_managemet_sytem.model;

import com.backend.Hospital_managemet_sytem.model.enumerations.DoctorRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Lat name is required")
    private String lastName;

    @NotNull(message = "Doctor Specialization  is required")
    @Enumerated(EnumType.STRING)
    private DoctorRole specialization;


    private int experience;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Email  is required")
    private String email;

    @NotNull(message = "Department is required")
    private Long departmentId;
}
