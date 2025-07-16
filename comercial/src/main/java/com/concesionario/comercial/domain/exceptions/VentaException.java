package com.concesionario.comercial.domain.exceptions;

public class VentaException extends ServiceLayerException {
    public VentaException(String message) {
        super(message);
    }
    
    public VentaException(String message, Throwable cause) {
        super(message, cause);
    }
}
