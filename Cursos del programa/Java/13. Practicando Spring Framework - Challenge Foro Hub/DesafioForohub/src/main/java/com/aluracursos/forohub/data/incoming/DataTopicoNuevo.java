package com.aluracursos.forohub.data.incoming;

import com.aluracursos.forohub.data.DataCurso;

public record DataTopicoNuevo(
        String titulo,
        String autor, // in reality this should use the token to get the subject instead
        String mensaje,
        DataCurso curso
) {
}
