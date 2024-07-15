package com.aluracursos.DesafioLiterAlura.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiTalker {
    private static HttpClient client = HttpClient.newHttpClient();
    private static HttpResponse<String> response;
    private static HttpRequest request;
    
    /**
     * @param url Base url to work with
     * @param query ? must be omitted. Spaces get converted into +
     * @return
     */
    public static String get(String url, String query) {
        request = HttpRequest.newBuilder().uri(URI.create(url + parseParams(query))).build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println(response.headers());
        return response.body();
    }

    public static String parseParams(String query) {
        if (query == null)
            return "";
        return "?" + query.replace(" ", "+");
    }
}
