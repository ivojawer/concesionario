package com.concesionario.stock.domain.exceptions;

public class NotFoundException extends RepositoryException {
    public NotFoundException(String message) {
        super(message);
    }
    
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
