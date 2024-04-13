package com.aluracursos.screenmatch.excepciones;

public class ErrorConversionDeDuracion extends RuntimeException {
    private String mensaje;
    public ErrorConversionDeDuracion(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
