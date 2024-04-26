package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula("Supaidamn 2", 1990);
        pelicula1.addNota(9);
        pelicula1.setDuracion(120);
        pelicula1.setIncluidoEnPlan(true);

        Pelicula pelicula2 = new Pelicula("Supaidamn 1", 1988);
        pelicula1.setDuracion(100);
        pelicula2.addNota(8);
        pelicula2.setIncluidoEnPlan(true);

        var pelicula3 = new Pelicula("El señor de los anillos", 2001);
        pelicula3.setDuracion(180);
        pelicula3.addNota(6);

        Serie casaDragon = new Serie("La casa de dragon", 2002);
        casaDragon.setDuracionEpisodio(20);
        casaDragon.addNota(4);
        casaDragon.setIncluidoEnPlan(true);
        casaDragon.mostrarFichaTecnica();



//        var lista = new ArrayList<Titulo>();
        List<Titulo> lista = new ArrayList<Titulo>();

        lista.add(pelicula1);
        lista.add(pelicula2);
        lista.add(pelicula3);
        lista.add(casaDragon);

        for (Titulo item: lista) {
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.printf("Item: %s [%d] \n", pelicula.getNombre(), pelicula.getClasificacion());
            }
        }

        lista.forEach(item -> System.out.println(item.getNombre()));


        System.out.printf("""
                Cantidad de peliculas: %d
                La primera pelicula es %s
                """, lista.size(), lista.get(0).getNombre());
        System.out.println(lista);


        var listaArtistas = new ArrayList<String>();
        listaArtistas.add("Yanuela");
        listaArtistas.add("Anolo");
        listaArtistas.add("Martin");

        Collections.sort(listaArtistas);
        System.out.println(listaArtistas);

        System.out.println(lista);
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getFechaLanzamiento));
        System.out.println(lista);
    }
}
