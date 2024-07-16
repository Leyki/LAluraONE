package com.aluracursos.forohub.data.incoming;

import com.aluracursos.forohub.models.Categoria;
import com.aluracursos.forohub.models.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCursoNuevo(
        @NotBlank String nombre,
        @NotNull Categoria categoria) {

    public DataCursoNuevo(Curso curso) {
        this(curso.getNombre(), curso.getCategoria());
    }
}
