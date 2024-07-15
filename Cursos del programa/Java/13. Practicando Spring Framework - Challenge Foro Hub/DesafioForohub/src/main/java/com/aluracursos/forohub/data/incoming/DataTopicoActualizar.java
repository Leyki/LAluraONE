package com.aluracursos.forohub.data.incoming;

import com.aluracursos.forohub.data.DataCurso;
import com.aluracursos.forohub.models.Status;

public record DataTopicoActualizar(
        Long id,
        Status status,
        String titulo,
        String mensaje,
        DataCurso curso
) {
}
