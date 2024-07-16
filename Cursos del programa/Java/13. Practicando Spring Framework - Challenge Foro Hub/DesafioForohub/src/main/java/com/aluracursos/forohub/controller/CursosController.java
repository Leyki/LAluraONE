package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.data.incoming.DataCursoNuevo;
import com.aluracursos.forohub.data.outgoing.DataCurso;
import com.aluracursos.forohub.models.Curso;
import com.aluracursos.forohub.repositories.CursosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/cursos")
public class CursosController {
    @Autowired
    private CursosRepository cursosRepository;


    @GetMapping
    @Transactional
    public ResponseEntity<List<DataCurso>> listarCursos() {
        List<DataCurso> cursos = cursosRepository.findAll().stream().map(DataCurso::new).toList();
        return ResponseEntity.ok(cursos);
    }
    /*@GetMapping("/{id}")
    public ResponseEntity<DataTopico> cargarTopico () {
        return ResponseEntity.ok();
    }*/

    @PostMapping
    @Transactional
    public ResponseEntity<DataCurso> crearNuevoCurso(@RequestBody @Valid DataCursoNuevo data, UriComponentsBuilder uriComponentsBuilder) {
        DataCurso curso = new DataCurso(cursosRepository.save(new Curso(data)));
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.id()).toUri();
        return ResponseEntity.created(url).body(curso);
    }
}
