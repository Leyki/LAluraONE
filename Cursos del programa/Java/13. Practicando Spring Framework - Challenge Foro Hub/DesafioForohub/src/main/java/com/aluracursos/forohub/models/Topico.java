package com.aluracursos.forohub.models;

import com.aluracursos.forohub.data.incoming.DataTopicoActualizar;
import com.aluracursos.forohub.data.incoming.DataTopicoNuevo;
import com.aluracursos.forohub.data.outgoing.DataTopico;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity(name = "Topico")
@Table(name = "topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario autor;
    @ManyToOne(fetch = FetchType.LAZY)
    private Curso curso;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Respuesta> respuestas;


    public Topico(Status status, String titulo, String mensaje, LocalDateTime fechaCreacion, Usuario autor, Curso curso) {
        this.status = status;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.autor = autor;
        this.curso = curso;
    }

    public Topico(DataTopicoNuevo data, Usuario usuario, Curso curso) {
        this(
                Status.OPEN,
                data.titulo(),
                data.mensaje(),
                LocalDateTime.now(),
                usuario,
                curso
        );
    }

    public void actualizar(DataTopicoActualizar data) {
        if (data.status() != null) this.setStatus(data.status());
        if (data.mensaje() != null) this.setMensaje(data.mensaje());
        if (data.titulo() != null) this.setTitulo(data.titulo());
        //if (data.cursoId() != null) this.setCurso(data.cursoId()); todo
    }

}


