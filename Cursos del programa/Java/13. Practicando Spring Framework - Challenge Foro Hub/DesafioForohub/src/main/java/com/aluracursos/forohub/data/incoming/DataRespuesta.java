package com.aluracursos.forohub.data.incoming;

import com.aluracursos.forohub.data.outgoing.DataUsuarioPublic;
import com.aluracursos.forohub.models.Respuesta;

import java.time.LocalDateTime;

public record DataRespuesta(
        Long id,
        DataUsuarioPublic autor,
        Boolean solucion,
        String mensaje,
        LocalDateTime fechaCreacion
) {
    public DataRespuesta(Respuesta respuesta) {
        this(
                respuesta.getId(),
                new DataUsuarioPublic(respuesta.getAutor()),
                respuesta.getSolucion(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion()
        );

    }
}
