package com.aluracursos.screenmatch.modelos;

public class Titulo {
    private String nombre;
    private int fechaLanzamiento;
    private int duracion;
    private boolean incluidoEnPlan;

    private double notasTotal = 0;
    private int notasCantidad = 0;

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

    public void sumarNota(double nota) {
        this.notasTotal += nota;
        this.notasCantidad++;
    }

    public double calcularMedia() {
        return this.notasTotal / this.notasCantidad;
    }
}

