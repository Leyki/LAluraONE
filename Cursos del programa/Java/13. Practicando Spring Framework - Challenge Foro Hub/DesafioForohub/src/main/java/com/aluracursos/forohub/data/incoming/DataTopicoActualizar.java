package com.aluracursos.forohub.data.incoming;

import com.aluracursos.forohub.models.Status;

public record DataTopicoActualizar(
        Status status,
        String titulo,
        String mensaje,
        Long cursoId
) {
}
