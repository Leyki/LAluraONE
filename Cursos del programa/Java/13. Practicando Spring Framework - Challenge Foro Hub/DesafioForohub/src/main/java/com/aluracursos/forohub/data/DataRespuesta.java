package com.aluracursos.forohub.data;

import com.aluracursos.forohub.data.incoming.DataUsuarioRegistro;

import java.util.Date;

public record DataRespuesta(
        Long id,
        DataUsuarioRegistro autor,
        Boolean solucion,
        String mensaje,
        Date fechaCreacion
) {
}
