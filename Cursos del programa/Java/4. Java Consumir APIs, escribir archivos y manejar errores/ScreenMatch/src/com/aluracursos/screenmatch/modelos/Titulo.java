package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.excepciones.ErrorConversionDeDuracion;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    private String nombre;
    private int fechaLanzamiento;
    private int duracion;
    private boolean incluidoEnPlan;

    private double notasTotal = 0;
    private int notasCantidad = 0;


    public Titulo(String nombre, int fechaLanzamiento) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Titulo(TituloOmdb tituloOmdb) {
        nombre = tituloOmdb.title();
        fechaLanzamiento = Integer.valueOf(tituloOmdb.year());
        if (tituloOmdb.runtime().contains("N/A")) {
            throw new ErrorConversionDeDuracion("No pude convertir la duracion, " +
                    "porque contiene un N/A");
        }
        duracion = Integer.valueOf(tituloOmdb.runtime().substring(0, 3).replace(" ", ""));
    }

    @Override
    public String toString() {
        return nombre + " - " + fechaLanzamiento + " - " + duracion;
    }
    public String toJson() {
        return """
                {
                "nombre": "%s",
                "fechaLanzamiento": "%s",
                "duracion": %d,
                }
                """.formatted(nombre, fechaLanzamiento, duracion);
    }

    public String getNombre() {
        return nombre;
    }
    public int getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public boolean isIncluidoEnPlan() {
        return incluidoEnPlan;
    }
    public int getNotasCantidad() {
        return notasCantidad;
    }
    public double getNotasTotal() {
        return notasTotal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFechaLanzamiento(int fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
    public void setIncluidoEnPlan(boolean incluidoEnPlan) {
        this.incluidoEnPlan = incluidoEnPlan;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void mostrarFichaTecnica() {
        System.out.printf("""
                Titulo: %s
                Duración: %d
                """, this.nombre, getDuracion());
    }

    public void addNota(double nota) {
        this.notasTotal += nota;
        this.notasCantidad++;
    }

    public double calcularMedia() {
        return this.notasTotal / this.notasCantidad;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.nombre.compareTo(otroTitulo.getNombre());
    }
}

