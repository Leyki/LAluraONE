package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.data.incoming.DataRespuesta;
import com.aluracursos.forohub.data.incoming.DataRespuestaNueva;
import com.aluracursos.forohub.models.Respuesta;
import com.aluracursos.forohub.models.Topico;
import com.aluracursos.forohub.models.Usuario;
import com.aluracursos.forohub.repositories.CursosRepository;
import com.aluracursos.forohub.repositories.RespuestasRepository;
import com.aluracursos.forohub.repositories.TopicosRepository;
import com.aluracursos.forohub.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/respuestas")
public class RespuestasController {
    @Autowired
    private TopicosRepository topicosRepository;
    @Autowired
    private RespuestasRepository respuestasRepository;
    @Autowired
    private CursosRepository cursosRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

   /* @GetMapping
    public ResponseEntity<Page<DataRespuesta>> listarRespuestas(@PageableDefault(size = 10) Pageable page) {
    }*/

    /*@PostMapping("/{id}")
    @Transactional
    public ResponseEntity<DataRespuesta> crearNuevaRespuesta(@RequestBody @Valid DataRespuestaNueva data, Long id, UriComponentsBuilder uriComponentsBuilder) {
        Usuario autor = usuarioRepository.findByNombre(data.autor());
        Optional<Topico> topico = topicosRepository.findById(id);
        if (topico.isEmpty()) return ResponseEntity.notFound().build();

        Respuesta topico = respuestasRepository.save(new Respuesta(id, data, autor));
        DataRespuesta dataRespuesta = new DataRespuesta(topico);
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(dataRespuesta.id()).toUri();
        return ResponseEntity.created(url).body(dataRespuesta);
    }*/

    /*@GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DataRespuesta> cargarRespuesta(@PathVariable Long id) {
        Optional<Respuesta> topico = respuestasRepository.findById(id);
        if (topico.isEmpty()) return ResponseEntity.notFound().build();
        DataRespuesta dataRespuesta = new DataRespuesta(topico.get());
        return ResponseEntity.ok(dataRespuesta);
    }*/

   /* @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DataRespuesta> actualizarRespuesta(@RequestBody DataRespuestaActualizar data, @PathVariable Long id) {
        Optional<Respuesta> respuestas = respuestasRepository.findById(id);
        if (respuestas.isEmpty()) return ResponseEntity.notFound().build();

        //respuestas.get().actualizar(data);
        respuestasRepository.save(respuestas.get());

        DataRespuesta dataRespuesta = new DataRespuesta(respuestas.get());
        return ResponseEntity.ok(dataRespuesta);
    }*/

    /*@DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity removerRespuesta(@PathVariable Long id) {
        Optional<Respuesta> topico = respuestasRepository.findById(id);
        if (topico.isEmpty()) return ResponseEntity.notFound().build();

        respuestasRepository.delete(topico.get());
        return ResponseEntity.noContent().build();
    }*/
}
