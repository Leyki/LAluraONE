package com.aluracursos.DesafioLiterAlura.repository;

import com.aluracursos.DesafioLiterAlura.models.Author;
import com.aluracursos.DesafioLiterAlura.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorsRepo extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE a.birthYear <= :year AND (a.deathYear IS NULL OR a.deathYear >= :year)")
    List<Author> findAliveAuthorsInYear(Integer year);
    Author findByName(String name);
}
