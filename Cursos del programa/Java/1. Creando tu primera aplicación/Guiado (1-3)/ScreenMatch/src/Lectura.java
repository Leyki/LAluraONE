import java.util.Scanner;

public class Lectura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe el nombre de tu pelicula favorita");
        String pelicula = scanner.nextLine();
        System.out.println("Ahora escribe la fecha de lanzamiento");
        int fechaLanzamiento = scanner.nextInt();
        System.out.println("Ahora escribe la nota de la pelicula");
        double nota = scanner.nextDouble();

        System.out.printf("%s, %d, %.2f\n", pelicula, fechaLanzamiento, nota);
        scanner.close();
    }
}
