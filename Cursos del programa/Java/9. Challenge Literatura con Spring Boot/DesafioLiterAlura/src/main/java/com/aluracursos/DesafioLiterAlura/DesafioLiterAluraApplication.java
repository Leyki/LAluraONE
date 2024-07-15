package com.aluracursos.DesafioLiterAlura;

import com.aluracursos.DesafioLiterAlura.principal.Principal;
import com.aluracursos.DesafioLiterAlura.repository.AuthorsRepo;
import com.aluracursos.DesafioLiterAlura.repository.BooksRepo;
import com.aluracursos.DesafioLiterAlura.repository.TranslatorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioLiterAluraApplication implements CommandLineRunner {
    @Autowired
    private BooksRepo booksRepo;
    @Autowired
    private AuthorsRepo authorsRepo;
    @Autowired
    private TranslatorsRepo translatorsRepo;

    public static void main(String[] args) {
        SpringApplication.run(DesafioLiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(booksRepo, authorsRepo, translatorsRepo);
        principal.menuLoop();
    }
}
