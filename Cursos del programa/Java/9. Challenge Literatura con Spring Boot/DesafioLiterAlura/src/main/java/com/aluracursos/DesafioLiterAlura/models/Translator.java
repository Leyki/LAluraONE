package com.aluracursos.DesafioLiterAlura.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "translators")
public class Translator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String name;
    Integer birthYear;
    Integer deathYear;
    @ManyToMany
    List<Book> books;
    public Translator() {}

    public Translator(DatosPerson dP) {
        this.name = dP.name();
        this.birthYear = dP.birthYear();
        this.deathYear = dP.deathYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
