package com.aluracursos.radioalura.modelos;

public class Podcast extends Audio {
    private String locutor;
    private String descripcion;

    public String getLocutor() {
        return locutor;
    }

    public void setLocutor(String locutor) {
        this.locutor = locutor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int getRating() {
        if (getTotalReproducciones() >= 10000 ) {
            return 3;
        }
        else if (getTotalReproducciones() >= 4000) {
            return 2;
        }
        else {
            return 1;
        }
    }
}
