package com.aluracursos.DesafioLiterAlura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private Long id;
    private String title;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> subjects;
    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Author> authors;
    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Translator> translators;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> languages;
    @JsonAlias("download_count")
    private Long downloads;

    public Book() {
    }

    public Book(DatosBook dB) {
        this.id = dB.id();
        this.title = dB.title();
        this.subjects = dB.subjects();
        this.authors = dB.authors().stream().map(Author::new).toList();
        this.translators = dB.translators().stream().map(Translator::new).toList();
        this.languages = dB.languages();
        this.downloads = dB.downloads();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subjects=" + subjects +
                ", authors=" + authors +
                ", translators=" + translators +
                ", languages=" + languages +
                ", downloads=" + downloads +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Translator> getTranslators() {
        return translators;
    }

    public void setTranslators(List<Translator> translators) {
        this.translators = translators;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }
}
