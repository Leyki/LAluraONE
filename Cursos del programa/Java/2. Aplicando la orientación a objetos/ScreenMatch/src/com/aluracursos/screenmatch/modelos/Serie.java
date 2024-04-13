package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Serie extends Titulo {
    private int temporadas;
    private int episodiosTemporada;
    private int duracionEpisodio;

    @Override
    public int getDuracion() {
        return temporadas * episodiosTemporada * duracionEpisodio;
    }

    public int getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodiosTemporada() {
        return episodiosTemporada;
    }

    public void setEpisodiosTemporada(int episodiosTemporada) {
        this.episodiosTemporada = episodiosTemporada;
    }

    public int getDuracionEpisodio() {
        return duracionEpisodio;
    }

    public void setDuracionEpisodio(int duracionEpisodio) {
        this.duracionEpisodio = duracionEpisodio;
    }

}
