package com.backend.Hospital_managemet_sytem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Patient is required")
    private Long patientId;

    @NotNull(message = "Doctor is required")
    private Long doctorId;

    @NotBlank(message = "First name is required")
    private Long appointmentId;

    @NotBlank(message = "Medication  is required")
    private String medication;

    @NotBlank(message = "Dosage  is required")
    private String dosage;

    @NotBlank(message = "Duration is required")
    private String duration;

    private String notes;

}
