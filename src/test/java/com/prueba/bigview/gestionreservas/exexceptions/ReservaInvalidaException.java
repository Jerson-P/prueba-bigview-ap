package com.prueba.bigview.gestionreservas.exexceptions;

public class ReservaInvalidaException extends RuntimeException {
	
    public ReservaInvalidaException(String message) {
        super(message);
    }

    public ReservaInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

}
