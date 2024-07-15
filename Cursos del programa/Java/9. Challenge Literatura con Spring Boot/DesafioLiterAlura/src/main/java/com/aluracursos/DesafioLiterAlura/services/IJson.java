package com.aluracursos.DesafioLiterAlura.services;

public interface IJson {
    <T> T parse(String json, Class<T> clase);
}
