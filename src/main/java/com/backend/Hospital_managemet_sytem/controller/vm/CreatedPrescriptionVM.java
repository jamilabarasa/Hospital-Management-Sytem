package com.backend.Hospital_managemet_sytem.controller.vm;

import com.backend.Hospital_managemet_sytem.model.Prescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedPrescriptionVM {

    private Prescription prescription;
    private SuccessReponseVM successReponse;
}
