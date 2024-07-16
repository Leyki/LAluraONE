package com.aluracursos.forohub.data.outgoing;

import com.aluracursos.forohub.models.Status;
import com.aluracursos.forohub.models.Topico;

import java.time.LocalDateTime;

public record DataTopicoPrevista(
        Long id,
        Status status,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        DataUsuarioPublic autor,
        DataCurso curso
) {

    public DataTopicoPrevista(Topico nuevoTopico) {
        this(
                nuevoTopico.getId(),
                nuevoTopico.getStatus(),
                nuevoTopico.getTitulo(),
                nuevoTopico.getMensaje(),
                nuevoTopico.getFechaCreacion(),
                new DataUsuarioPublic(nuevoTopico.getAutor()),
                new DataCurso(nuevoTopico.getCurso())
        );
    }
}
