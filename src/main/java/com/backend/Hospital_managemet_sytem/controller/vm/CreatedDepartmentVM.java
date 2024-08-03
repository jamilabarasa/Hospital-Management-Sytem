package com.backend.Hospital_managemet_sytem.controller.vm;

import com.backend.Hospital_managemet_sytem.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedDepartmentVM {

    private Department department;
    private SuccessReponseVM successReponse;
}
