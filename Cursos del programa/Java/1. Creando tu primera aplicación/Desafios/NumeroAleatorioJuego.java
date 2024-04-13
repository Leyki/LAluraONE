import java.util.Scanner;
import java.util.Random;

public class NumeroAleatorioJuego {
    public static void main(String[] args) {
        /*
        Crea un programa que simule un juego de adivinanzas.
        El programa debe generar un número aleatorio entre 0 y 100,
        y pedir al usuario que intente adivinar ese número en un máximo de 5 intentos.
        En cada intento, el programa debe informar si el número ingresado por el usuario
        es mayor o menor que el número generado.
         */

        Scanner scanner = new Scanner(System.in);
        int numeroAleatorio = new Random().nextInt(100);
        int numeroElegido = 0;
        System.out.println(numeroAleatorio);
        while (numeroElegido != numeroAleatorio) {
            if (numeroElegido == 0) {
                System.out.println("Por favor ingrese un número del 1 al 100");
            }
            else if (numeroElegido > numeroAleatorio) {
                System.out.println("El número aleatorio es menor");
            }
            else if (numeroElegido < numeroAleatorio) {
                System.out.println("El número aleatorio es mayor");
            }
            numeroElegido = scanner.nextInt();
            System.out.println(numeroElegido);
        }
        System.out.println("¡Ganaste!");
    }
}