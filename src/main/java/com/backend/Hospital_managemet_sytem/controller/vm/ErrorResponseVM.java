package com.backend.Hospital_managemet_sytem.controller.vm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseVM {

    private String message;

    private String status;

    private int statusCode;

    private Long timeStamp;


}
