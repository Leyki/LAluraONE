package com.aluracursos.radioalura.main;

import com.aluracursos.radioalura.modelos.*;

public class Main {
    public static void main(String[] args) {

        Cancion cancion1 = new Cancion();
        cancion1.setTitulo("Buen borro");
        cancion1.setAlbum("Doremo");
        cancion1.setAutor("Martin");
        cancion1.setGenero("Damasca");
        cancion1.setDuracion(180);


        Podcast podcast1 = new Podcast();
        podcast1.setTitulo("Podcastito");
        podcast1.setLocutor("Luri");
        podcast1.setDescripcion("Podcast sobre IA");
        podcast1.setDuracion(60*60);


        cancion1.setMeGusta(100);
        cancion1.setTotalReproducciones(5000);

        podcast1.setMeGusta(100);
        podcast1.setTotalReproducciones(5000);

        System.out.printf("""
                Total de megusta: %d
                Total de reproducciones: %d
                """, cancion1.getMeGusta(), cancion1.getTotalReproducciones());

        MisFavoritos favoritos = new MisFavoritos();

        favoritos.agregar(cancion1);
        favoritos.agregar(podcast1);
    }



}