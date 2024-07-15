package com.aluracursos.DesafioLiterAlura.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosPerson(
        String name,
        @JsonAlias("birth_year") Integer birthYear,
        @JsonAlias("death_year") Integer deathYear) {

    @Override
    public final String toString() {
        return name + " | AñoNac: " + birthYear + " AñoMuer: " + deathYear;
    }
}
