package com.backend.Hospital_managemet_sytem.controller.vm;

import com.backend.Hospital_managemet_sytem.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedUserVM {

    private User user;

    private SuccessReponseVM successReponse;
}
