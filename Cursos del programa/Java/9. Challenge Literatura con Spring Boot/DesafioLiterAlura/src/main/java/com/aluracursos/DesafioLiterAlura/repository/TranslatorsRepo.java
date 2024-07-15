package com.aluracursos.DesafioLiterAlura.repository;

import com.aluracursos.DesafioLiterAlura.models.Translator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TranslatorsRepo extends JpaRepository<Translator, Long> {
    @Query("SELECT t FROM Translator t WHERE t.birthYear <= :year AND (t.deathYear IS NULL OR t.deathYear >= :year)")
    List<Translator> findAliveTranslatorsInYear(Integer year);
    Translator findByName(String name);
}
