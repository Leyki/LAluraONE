package com.aluracursos.radioalura.modelos;

public class MisFavoritos {

    public void agregar (Audio audio) {
        if (audio.getRating() == 3) {
            System.out.println(audio.getTitulo() +  " - Muy bien clasificado actualmente");
        }
        else if (audio.getRating() == 2) {
            System.out.println(audio.getTitulo() +  " - Bien clasificado actualmente");
        }
        else if (audio.getRating() == 1) {
            System.out.println(audio.getTitulo() +  " - No muy bien clasificado actualmente");
        }
    }
}
