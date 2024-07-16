package com.aluracursos.forohub.data.outgoing;

import com.aluracursos.forohub.models.Categoria;
import com.aluracursos.forohub.models.Curso;

public record DataCurso(
        Long id,
        String nombre,
        Categoria categoria) {

    public DataCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
