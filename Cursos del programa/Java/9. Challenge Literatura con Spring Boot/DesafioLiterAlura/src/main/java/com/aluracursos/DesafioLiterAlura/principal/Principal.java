package com.aluracursos.DesafioLiterAlura.principal;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.aluracursos.DesafioLiterAlura.models.*;
import com.aluracursos.DesafioLiterAlura.repository.AuthorsRepo;
import com.aluracursos.DesafioLiterAlura.repository.BooksRepo;
import com.aluracursos.DesafioLiterAlura.repository.TranslatorsRepo;
import com.aluracursos.DesafioLiterAlura.services.*;
import org.springframework.beans.factory.annotation.Autowired;

public class Principal {
    private final Scanner scanner = new Scanner(System.in);
    private final Json json = new Json();
    private final String URL = "https://gutendex.com/books/";
    private BooksRepo booksRepo;
    private AuthorsRepo authorsRepo;
    private TranslatorsRepo translatorsRepo;

    public Principal(BooksRepo booksRepo, AuthorsRepo authorsRepo, TranslatorsRepo translatorsRepo) {
        this.booksRepo = booksRepo;
        this.authorsRepo = authorsRepo;
        this.translatorsRepo = translatorsRepo;
    }

    public void menuLoop() {
        String menu = """
                1 - Buscar libro por nombre
                2 - Listar libros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos en un determinado año
                5 - Listar libros por idioma
                                    
                0 - Salir
                """;
        Integer opcion = -1;
        while (opcion != 0) {
            System.out.println(menu);
            String input = scanner.nextLine();
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Argumento de tipo invalido, tiene que ser un número.");
            }
            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosEnAño();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }


    public void buscarLibro() {
        System.out.println("Escribe el nombre del libro que deseas encontrar");
        String input = scanner.nextLine();
        String response = ApiTalker.get(URL, "search=" + input);
        var librosEncontrados = json.parse(response, DatosBooks.class);

        if (librosEncontrados.results().isEmpty())
            System.out.println("No se ha encontrado ningún libro con este nombre");

        System.out.println("Libros encontrados con el nombre dado: ");

        librosEncontrados.results().stream().limit(5).forEach(b -> {
            System.out.println(b.friendlyPrint());
        });
        DatosBook datosLibro = librosEncontrados.results().get(0);
        System.out.println("\nLibro más relevante a la busqueda: " + datosLibro);
        var book = new Book(datosLibro);
        if (booksRepo.findById(book.getId()).isEmpty()) {
            booksRepo.save(book);
            System.out.println("El libro " + book.getTitle() + " ha sido guardado.");
        }
    }

    private void listarLibrosRegistrados() {
        List<Book> books = booksRepo.findAll();
        if (books.isEmpty()) System.out.println("Ningún libro encontrado.");
        else System.out.println(books);
    }

    private void listarAutoresRegistrados() {
        List<Author> authors = authorsRepo.findAll();
        if (authors.isEmpty()) System.out.println("Ningún autor encontrado.");
        else System.out.println(authors);
    }

    private void listarAutoresVivosEnAño() {
        System.out.println("En cuál año?");
        String input = scanner.nextLine();
        Integer anio = 0;
        try {
            anio = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Argumento de tipo invalido, tiene que ser un número.");
        }
        List<Author> authors = authorsRepo.findAliveAuthorsInYear(anio);
        if (authors.isEmpty()) System.out.println("Ningún autor encontrado.");
        else System.out.println(authors);

    }

    private void listarLibrosPorIdioma() {
        System.out.println("Por cuál idioma? (es, en, fr, pt, etc.)");
        String input = scanner.nextLine();
        List<Book> books = booksRepo.findByLanguagesContaining(input);
        if (books.isEmpty()) System.out.println("Ningún libro encontrado.");
        else System.out.println(books);
    }

    public void dataTest() { // api
        String response = ApiTalker.get(URL, "");
        var libros = json.parse(response, DatosBooks.class);
        System.out.println();
        System.out.println("<Datos random>");
        libros.results().stream().limit(5).forEach(System.out::println);
    }

    public void mostrarLibrosMasDescargados(Integer max) { // api
        System.out.println();
        System.out.println("<Top 10 libros más descargados>");
        String response = ApiTalker.get(URL, "language=es&sort=popular");
        var librosPopulares = json.parse(response, DatosBooks.class);
        librosPopulares.results().stream().limit(max).forEach(b -> {
            System.out.println(b.title());
        });
        // Implementación de estadisticas básicas
        System.out.println("Algunas estadisticas de descargas sobre los 10 libros más populares");
        LongSummaryStatistics est = librosPopulares.results().stream().limit(10).collect(Collectors.summarizingLong(DatosBook::downloads));
        System.out.printf("\n Total: %d Mín: %d Promedio: %.0f Máx: %d ", est.getSum(), est.getMin(), est.getAverage(), est.getMax());
    }

}
