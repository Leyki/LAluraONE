package com.aluracursos.tarjetadecompras.modelos;


public class Item implements Comparable<Item> {
    private String nombre;
    private double costo;


    public Item(String nombre, double costo) {
        setNombre(nombre);
        setCosto(costo);
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int compareTo(Item o) {
        return Double.compare(this.costo, o.costo);
        //return this.costo >= o.costo ? 1 : 0;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }

}
