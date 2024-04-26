package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.excepciones.ErrorConversionDeDuracion;
import com.aluracursos.screenmatch.modelos.*;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //var listaTitulos = new ArrayList<Titulo>();
        List<Titulo> listaTitulos = new ArrayList<>();
        var sitio = "https://www.omdbapi.com/?";
        var apikey = "88768aa5";
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {
            System.out.println("Indique que pelicula quiere buscar:");
            String busqueda;
            busqueda = scanner.nextLine();
            if (busqueda.equals("salir")) break;

            var direccion = sitio + "apikey=" + apikey + "&t=" + busqueda.replace(" ", "+");
            System.out.println(direccion);
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(tituloOmdb);
                Titulo titulo = new Titulo(tituloOmdb);
                System.out.println("Convertido: " + titulo);

                listaTitulos.add(titulo);
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la direccion: " + e.getMessage());
            } catch (ErrorConversionDeDuracion e) {
                System.out.println("Error de conversion: " + e.getMensaje());
            } catch (Exception e) {
                System.out.println("Error desconocido: " + e);
            }
        }
        FileWriter escritor = new FileWriter("titulos.json");
        escritor.write(gson.toJson(listaTitulos));
        escritor.close();
        System.out.println(listaTitulos);

    }
}
