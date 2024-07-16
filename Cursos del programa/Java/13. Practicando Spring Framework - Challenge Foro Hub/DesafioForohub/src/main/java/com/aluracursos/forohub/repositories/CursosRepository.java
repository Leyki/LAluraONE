package com.aluracursos.forohub.repositories;

import com.aluracursos.forohub.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends JpaRepository<Curso, Long> {
}
