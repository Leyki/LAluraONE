package com.aluracursos.DesafioLiterAlura.models;

import java.util.List;

public record DatosBooks(
        Integer count,
        String next,
        String previous,
        List<DatosBook> results) {
}
