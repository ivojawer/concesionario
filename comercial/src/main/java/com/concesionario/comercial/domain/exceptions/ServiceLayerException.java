package com.concesionario.comercial.domain.exceptions;

public class ServiceLayerException extends Exception {
    public ServiceLayerException(String message) {
        super(message);
    }
    
    public ServiceLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
