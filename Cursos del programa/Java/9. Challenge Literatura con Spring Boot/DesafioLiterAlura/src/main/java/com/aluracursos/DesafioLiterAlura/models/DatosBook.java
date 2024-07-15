package com.aluracursos.DesafioLiterAlura.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosBook(
        Long id,
        String title,
        List<String> subjects,
        List<DatosPerson> authors,
        List<DatosPerson> translators,
        List<String> languages,
        @JsonAlias("download_count") Long downloads) {
    @Override
    public final String toString() {
        return "Id: " + id + " Título: " + title + " Autores: " + authors;
    }

    public String friendlyPrint() {
        String authorsNames = "";
        if (authors.isEmpty())
            authorsNames = "Autor: desconocido";
        else if (authors.size() == 1)
            authorsNames = "Autor: " + authors.get(0).name();
        else {
            for (DatosPerson author : authors) {
                authorsNames += author.name() + ", ";
            }
            authorsNames = "Autores: " + authorsNames.substring(0, authorsNames.length()-2);
        }

        return "Título: " + title + " - " + authorsNames + " - Idiomas: " + languages;
    }
}
