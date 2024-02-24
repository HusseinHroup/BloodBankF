package com.Final.BloodBankF.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatientAndDonorRestExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<PatientAndDonorErrorResponse> HandleException (PatientAndDonorNotFoundException exc){
//the type be Response But the Paramater is NotFoundException
        PatientAndDonorErrorResponse Error = new PatientAndDonorErrorResponse();
        Error.setStatus(HttpStatus.NOT_FOUND.value());
        Error.setMessage(exc.getMessage());
        Error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(Error,HttpStatus.NOT_FOUND);
    }


    //Exception
    @ExceptionHandler
    public ResponseEntity<PatientAndDonorErrorResponse> HandleException (Exception exc){
//the type be Response But the Paramater is NotFoundException
        PatientAndDonorErrorResponse Error = new PatientAndDonorErrorResponse();
        Error.setStatus(HttpStatus.BAD_REQUEST.value());
        Error.setMessage(exc.getMessage()); // I can write anything want not condition in specefic condition
        Error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(Error,HttpStatus.BAD_REQUEST);
    }



}


