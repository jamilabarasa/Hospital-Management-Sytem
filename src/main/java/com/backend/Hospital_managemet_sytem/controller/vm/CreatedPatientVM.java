package com.backend.Hospital_managemet_sytem.controller.vm;

import com.backend.Hospital_managemet_sytem.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedPatientVM {

    private Patient patient;
    private SuccessReponseVM successReponse;
}
