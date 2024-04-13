package com.aluracursos.radioalura.modelos;

public class Audio {
    private String titulo = "";
    private double duracion = 0;
    private long totalReproducciones = 0;
    private long meGusta = 0;
    private int rating = -1;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public long getTotalReproducciones() {
        return totalReproducciones;
    }

    public void setTotalReproducciones(long totalReproducciones) {
        this.totalReproducciones = totalReproducciones;
    }

    public long getMeGusta() {
        return meGusta;
    }


    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void agregarGusta(int cantidad) {
        meGusta += cantidad;
    }
    public void reproducir() {
        System.out.printf("""
                Ahora reproduciendo %s con una duración de %.2f""", titulo, duracion);
    }
}
