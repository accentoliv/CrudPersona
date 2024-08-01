package com.crudpersona.crudpersona.errores;

public class PersonaNotFoundException extends RuntimeException{
    public PersonaNotFoundException() {
    }

    public PersonaNotFoundException(String message) {
        super(message);
    }

    public PersonaNotFoundException(Throwable cause) {
        super(cause);
    }

    public PersonaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonaNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
