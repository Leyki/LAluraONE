package com.aluracursos.forohub.data.outgoing;

import com.aluracursos.forohub.data.DataCurso;
import com.aluracursos.forohub.data.DataRespuesta;
import com.aluracursos.forohub.models.Respuesta;
import com.aluracursos.forohub.models.Status;
import com.aluracursos.forohub.models.Topico;

import java.time.LocalDateTime;
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
        this.id = nuevoTopico.getId();
        this.status = nuevoTopico.getStatus();
        this.titulo = nuevoTopico.getTitulo();
        this.mensaje = nuevoTopico.getMensaje();
        this.fechaCreacion = nuevoTopico.getFechaCreacion();
        this.autor = new DataUsuarioPublic(nuevoTopico.getAutor());
        this.curso = new DataCurso(nuevoTopico.getCurso().getNombre(), nuevoTopico.getCurso().getCategoria());
        this.respuestas = new Respuesta(nuevoTopico.respuestas());
    }
}
