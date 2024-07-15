package com.aluracursos.forohub.repositories;

import com.aluracursos.forohub.models.Curso;
import com.aluracursos.forohub.models.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CursosRepository extends JpaRepository<Curso, Long> {


}
