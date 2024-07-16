package com.aluracursos.forohub.repositories;

import com.aluracursos.forohub.models.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TopicosRepository extends JpaRepository<Topico, Long> {

    @Query("select t from Topico t join fetch t.autor join fetch t.curso where t.status = 'OPEN'")
    Page<Topico> findAllByStatusOPEN(Pageable page);
    @Query("select t from Topico t where lower(t.titulo) = lower(:titulo) and lower(t.mensaje) = lower(:mensaje)")
    Optional<Topico> findByTituloAndMensajeIgnoreCase(String titulo, String mensaje);

}
