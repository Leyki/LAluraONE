import swapi.Swapi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inicializando...");
        Swapi.consultarPeliculas();
        // Interface
        Scanner scanner = new Scanner(System.in);
        String opcion = "";
        while (opcion != "salir") {
            try {
                System.out.println("Por favor indique el nombre o nombre parcial de la pelicula que desea guardar. Escriba \"salir\" para finalizar.");
                opcion = scanner.nextLine();
            }
            catch (NumberFormatException e) {
                System.out.println("El argumento debe ser del tipo número.");
                throw new RuntimeException(e);
            }
            boolean encontrada = false;
            for (int i = 0; i < Swapi.getCantidadPeliculas(); i++) {
                if (Swapi.getPelicula(i).getTitle().toLowerCase().contains(opcion.toLowerCase())) {
                    System.out.println("Escribiendo " + Swapi.getPelicula(i).getTitle() + ".json");
                    Swapi.escribirPelicula(i);
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada)
                System.out.println("No se ha podido encontrar esa pelicula.");
        }
    }
}