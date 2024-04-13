package com.aluracursos.screenmatch.calculos;

public class Recomendaciones {

    public void filtrar(Clasificacion clasificacion) {
        if (clasificacion.getClasificacion() >= 4) {
            System.out.println("Con buena evaluación actualmente");
        }
        else if (clasificacion.getClasificacion() >= 2) {
            System.out.println("Popular por el momento actualmente");
        }
        else {
            System.out.println("No muy popular actualmente");
        }
    }
}
