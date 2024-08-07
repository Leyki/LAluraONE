package com.aluracursos.forohub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity(name = "Respuesta")
@Table(name = "respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario autor;
    private Boolean solucion;
    @ManyToOne(fetch = FetchType.LAZY)
    private Topico topico;
    private String mensaje;
    private LocalDateTime fechaCreacion;
}
