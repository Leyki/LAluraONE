package com.aluracursos.forohub.repositories;

import com.aluracursos.forohub.models.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RespuestasRepository extends JpaRepository<Respuesta, Long> {

}
