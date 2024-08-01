package com.crudpersona.crudpersona.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonaRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PersonaErrorResponse> handleException(PersonaNotFoundException exc) {


        PersonaErrorResponse error = new PersonaErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PersonaErrorResponse> handleException(Exception exc) {

        // create CustomerErrorResponse

        PersonaErrorResponse error = new PersonaErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
