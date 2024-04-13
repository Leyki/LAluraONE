import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double nota = 0;
        double notasTotal = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("¿Qué nota la darías a la pelicula Matrix?");
            nota = scanner.nextDouble();
            notasTotal += nota;
        }
        System.out.println(notasTotal / 3);
    }
}
