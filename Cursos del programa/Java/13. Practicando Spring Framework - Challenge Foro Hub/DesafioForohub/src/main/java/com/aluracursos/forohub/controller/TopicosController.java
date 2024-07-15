package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.data.incoming.DataTopicoNuevo;
import com.aluracursos.forohub.data.outgoing.DataTopico;
import com.aluracursos.forohub.models.Curso;
import com.aluracursos.forohub.models.Status;
import com.aluracursos.forohub.models.Topico;
import com.aluracursos.forohub.models.Usuario;
import com.aluracursos.forohub.repositories.CursosRepository;
import com.aluracursos.forohub.repositories.TopicosRepository;
import com.aluracursos.forohub.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


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
    public ResponseEntity<Page<Topico>> listarTopicos(@PageableDefault(size = 10) Pageable page) {
        Page<Topico> topicos = topicosRepository.findAllByStatusOPEN(page);
        return ResponseEntity.ok(topicos);


    }
    /*@GetMapping("/{id}")
    public ResponseEntity<DataTopico> cargarTopico () {
        return ResponseEntity.ok();
    }*/

    @PostMapping
    @Transactional
    //public ResponseEntity<Topico> crearNuevoTopico(@RequestBody @Valid DataTopicoNuevo data) {
    public ResponseEntity<DataTopico> crearNuevoTopico(@RequestBody @Valid DataTopicoNuevo data) {
        Topico nuevoTopico =  topicosRepository.save(buildTopico(data));
        DataTopico = new DataTopico(nuevoTopico);
        return ResponseEntity.ok().body(nuevoTopico);
    }

    /* Medico medico = topicosRepository.save(new Medico(datosRegistroMedico));
     DatosRespuestaMedico datosRespuestaMedico = DatosRepuestaMedicoFromMedico(medico);
      return 201 - created
     url donde encontrar al medico
     URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
     return ResponseEntity.created(url).body(datosRespuestaMedico);*/
    @Transactional
    private Topico buildTopico(DataTopicoNuevo data) {
        Usuario autor = usuarioRepository.findByNombre(data.autor());

        Curso curso = cursosRepository.save(new Curso(data.curso()));
        return new Topico(
                Status.OPEN,
                data.titulo(),
                data.mensaje(),
                LocalDateTime.now(),
                usuarioRepository.findByNombre(data.autor()),
                curso
        );
    }
}
