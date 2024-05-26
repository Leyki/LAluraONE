package com.aluracursos.screenmatch.service;

public interface IconvierteDatos {
    <T> T procesarDatos(String json, Class<T> clase);
}
