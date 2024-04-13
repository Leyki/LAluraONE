package com.aluracursos.radioalura.modelos;

public class Cancion extends Audio {
    private String album; // this could be an object
    private String autor;
    private String genero;


    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int getRating() {
        if (getTotalReproducciones() >= 5000 ) {
            return 3;
        }
        else if (getTotalReproducciones() >= 2000) {
            return 2;
        }
        else {
            return 1;
        }
    }
}
