package com.aluracursos.screenmatch.calculos;

import com.aluracursos.screenmatch.modelos.Titulo;

public class CalculadoraTiempo {
    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void incluir(Titulo titulo) {
        this.tiempoTotal += titulo.getDuracion();
    }
}
