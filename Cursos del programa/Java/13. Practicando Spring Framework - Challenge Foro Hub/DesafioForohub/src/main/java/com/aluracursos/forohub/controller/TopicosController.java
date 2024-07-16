package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.data.incoming.DataTopicoActualizar;
import com.aluracursos.forohub.data.incoming.DataTopicoNuevo;
import com.aluracursos.forohub.data.outgoing.DataTopico;
import com.aluracursos.forohub.data.outgoing.DataTopicoPrevista;
import com.aluracursos.forohub.models.*;
import com.aluracursos.forohub.repositories.CursosRepository;
import com.aluracursos.forohub.repositories.TopicosRepository;
import com.aluracursos.forohub.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicosRepository topicosRepository;
    @Autowired
    private CursosRepository cursosRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<Page<DataTopicoPrevista>> listarTopicos(@PageableDefault(size = 10) Pageable page) {
        Page<DataTopicoPrevista> dataTopicos = topicosRepository.findAllByStatusOPEN(page).map(DataTopicoPrevista::new);
        return ResponseEntity.ok(dataTopicos);


    }

    @PostMapping
    @Transactional
    public ResponseEntity<DataTopico> crearNuevoTopico(@RequestBody @Valid DataTopicoNuevo data, UriComponentsBuilder uriComponentsBuilder) {
        Usuario autor = usuarioRepository.findByNombre(data.autor());
        Optional<Curso> curso = cursosRepository.findById(data.cursoId());
        if (curso.isEmpty()) return ResponseEntity.badRequest().build();
        Optional<Topico> topicoQuery = topicosRepository.findByTituloAndMensajeIgnoreCase(data.titulo(), data.mensaje());
        if (topicoQuery.isPresent()) return ResponseEntity.badRequest().build(); // todo tell why

        Topico topico = topicosRepository.save(new Topico(data, autor, curso.get()));
        DataTopico dataTopico = new DataTopico(topico);
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(dataTopico.id()).toUri();
        return ResponseEntity.created(url).body(dataTopico);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DataTopico> cargarTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicosRepository.findById(id);
        if (topico.isEmpty()) return ResponseEntity.notFound().build();
        DataTopico dataTopico = new DataTopico(topico.get());
        return ResponseEntity.ok(dataTopico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DataTopico> actualizarTopico(@RequestBody DataTopicoActualizar data, @PathVariable Long id) {
        Optional<Topico> topico = topicosRepository.findById(id);
        if (topico.isEmpty()) return ResponseEntity.notFound().build();

        Optional<Topico> topicoQuery = topicosRepository.findByTituloAndMensajeIgnoreCase(
                data.titulo() != null ? data.titulo() : topico.get().getTitulo(),
                data.mensaje() != null ? data.mensaje() : topico.get().getMensaje());
        if (topicoQuery.isPresent()) return ResponseEntity.badRequest().build(); // todo tell why

        topico.get().actualizar(data);
        DataTopico dataTopico = new DataTopico(topico.get());
        return ResponseEntity.ok(dataTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity removerTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicosRepository.findById(id);
        if (topico.isEmpty()) return ResponseEntity.notFound().build();

        topicosRepository.delete(topico.get());
        return ResponseEntity.noContent().build();
    }
}
