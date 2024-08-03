package com.backend.Hospital_managemet_sytem.security.exceptions;

import com.backend.Hospital_managemet_sytem.controller.vm.ErrorResponseVM;
import com.backend.Hospital_managemet_sytem.model.enumerations.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseVM> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponseVM errorResponse = new ErrorResponseVM();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(String.valueOf(Status.FAILURE));
        errorResponse.setTimeStamp(System.currentTimeMillis());
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseVM> handleBadRequestException(BadRequestException ex){
        ErrorResponseVM errorResponse = new ErrorResponseVM();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(String.valueOf(Status.FAILURE));
        errorResponse.setTimeStamp(System.currentTimeMillis());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponseVM> handleValidationException(ValidationException ex){
        ErrorResponseVM errorResponse = new ErrorResponseVM();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(String.valueOf(Status.FAILURE));
        errorResponse.setTimeStamp(System.currentTimeMillis());
        errorResponse.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseVM> handleGenericException(Exception ex){
        ErrorResponseVM errorResponse = new ErrorResponseVM();
        errorResponse.setMessage("An error occurred: " + ex.getMessage());
        //        errorResponse.setMessage("An error occurred: ");
        errorResponse.setStatus(String.valueOf(Status.FAILURE));
        errorResponse.setTimeStamp(System.currentTimeMillis());
        errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseVM> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        ErrorResponseVM errorResponse = new ErrorResponseVM();
        errorResponse.setMessage(String.join(", ", errors));
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setStatus(String.valueOf(Status.FAILURE));
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
