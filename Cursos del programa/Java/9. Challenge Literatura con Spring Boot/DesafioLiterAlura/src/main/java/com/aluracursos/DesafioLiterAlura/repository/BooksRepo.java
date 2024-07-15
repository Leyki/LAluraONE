package com.aluracursos.DesafioLiterAlura.repository;

import com.aluracursos.DesafioLiterAlura.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepo extends JpaRepository<Book, Long> {
    List<Book> findByLanguagesContaining(String lang);
}
