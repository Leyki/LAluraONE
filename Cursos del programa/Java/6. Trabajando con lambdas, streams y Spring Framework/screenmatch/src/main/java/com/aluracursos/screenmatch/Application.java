package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.models.DatosSerie;
import com.aluracursos.screenmatch.service.ConsumoApi;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String apiKey = "88768aa5";
        String omdbapiUrl = "http://www.omdbapi.com/?apikey=" + apiKey + "&";
        
        ConsumoApi consumoApi = new ConsumoApi();
        String datos = consumoApi.obtenerDatos(omdbapiUrl + "t=" + "neon genesis evangelion");

        ConvierteDatos conversor = new ConvierteDatos();
        var datosF = conversor.procesarDatos(datos, DatosSerie.class);
        System.out.println(datos);
        System.out.println(datosF);
    }
}
