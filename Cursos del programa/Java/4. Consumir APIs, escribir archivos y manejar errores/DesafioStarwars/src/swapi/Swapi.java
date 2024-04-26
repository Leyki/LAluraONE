package swapi;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class Swapi {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();
    static Peliculas peliculas = null;

    public static int getCantidadPeliculas() {
        return peliculas.lista.length;
    }

    public static Pelicula getPelicula(int id) {
        return peliculas.lista[id];
    }

    public static void consultarPeliculas() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://swapi.dev/api/films/"))
//                .timeout(Duration.ofMinutes(2))
                    .build();
            HttpResponse<String> response;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            peliculas = gson.fromJson(response.body(), Peliculas.class);
            //System.out.println(response.headers());
            System.out.println(Arrays.toString(peliculas.lista));
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    // do it by type if not lazy
    public static void escribirPelicula(int id) {
        try {
            FileWriter escritor = new FileWriter(peliculas.lista[id].title + ".json");
            escritor.write(gson.toJson(peliculas.lista[id]));
            escritor.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
