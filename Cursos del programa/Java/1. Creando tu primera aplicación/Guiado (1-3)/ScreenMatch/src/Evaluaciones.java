import java.util.Scanner;

public class Evaluaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double nota = 0;
        double notasTotal = 0;
        int evaluaciones = 0;

        while (evaluaciones != -1) {
            System.out.println("¿Qué nota la darías a la pelicula Matrix?");
            nota = scanner.nextDouble();
            if (nota == -1) {
                break;
            }
            notasTotal += nota;
            evaluaciones++;
        }
        System.out.println(notasTotal / evaluaciones);
    }
}
