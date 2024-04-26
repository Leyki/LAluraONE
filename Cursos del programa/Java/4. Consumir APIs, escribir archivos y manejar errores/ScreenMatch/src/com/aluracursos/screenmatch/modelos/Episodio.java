package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Episodio implements Clasificacion {
    private int numero;
    private String nombre;
    private Serie serie;

    public int getTotalVisualiciones() {
        return totalVisualiciones;
    }

    public void setTotalVisualiciones(int totalVisualiciones) {
        this.totalVisualiciones = totalVisualiciones;
    }

    private int totalVisualiciones;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Serie getSerie() {
        return serie;
    }
    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClasificacion() {
        return this.totalVisualiciones > 10 ? 4 : 2;
    }

}
