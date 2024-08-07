package com.aluracursos.forohub.data.outgoing;

import com.aluracursos.forohub.data.incoming.DataRespuesta;
import com.aluracursos.forohub.models.Status;
import com.aluracursos.forohub.models.Topico;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public record DataTopico(
        Long id,
        Status status,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        DataUsuarioPublic autor,
        DataCurso curso,
        List<DataRespuesta> respuestas
) {

    public DataTopico(Topico nuevoTopico) {
        this(
                nuevoTopico.getId(),
                nuevoTopico.getStatus(),
                nuevoTopico.getTitulo(),
                nuevoTopico.getMensaje(),
                nuevoTopico.getFechaCreacion(),
                new DataUsuarioPublic(nuevoTopico.getAutor()),
                new DataCurso(nuevoTopico.getCurso()),
                nuevoTopico.getRespuestas() != null
                        ? nuevoTopico.getRespuestas().stream().map(DataRespuesta::new).toList()
                        : Collections.emptyList()
        );
    }
}
