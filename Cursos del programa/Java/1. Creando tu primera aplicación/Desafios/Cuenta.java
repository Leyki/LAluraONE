import java.util.Scanner;

public class Cuenta {
     public static void main(String[] args) {
        String clienteNombre = "Cake";
        String clienteTipo = "Corriente";
        double clienteSaldo = 1000;
        System.out.printf("""
                <****************************>
                Nombre del cliente: %s
                Tipo de cuenta: %s
                Saldo de cuenta: %.2f$
                <****************************>
                """, clienteNombre, clienteTipo, clienteSaldo);

        int opcionElegida = 0;
        Scanner scanner = new Scanner(System.in);
        while (opcionElegida != 9) {
            System.out.println("""
                    ** Escriba el número de lo que desea realizar a continuación **
                    1 - Consultar saldo
                    2 - Retirar
                    3 - Depositar
                    9 - Salir
                    """);

            opcionElegida = scanner.nextInt();
            switch (opcionElegida) {
                case 1:
                    System.out.printf("El saldo actual es: %.2f$\n", clienteSaldo);
                    break;
                case 2:
                    System.out.println("¿Cuanto deseas retirar?");
                    int delta = scanner.nextInt();
					if (clienteSaldo - delta < 1) {
						System.out.println("Saldo insuficiente");
						break;
					}
					clienteSaldo -= delta;
                    System.out.printf("El saldo actualizado es: %.2f$\n", clienteSaldo);
                    break;
                case 3:
                    System.out.println("¿Cuanto deseas depositar?");
                    clienteSaldo += scanner.nextInt();
                    System.out.printf("El saldo actualizado es: %.2f$\n", clienteSaldo);
                    break;
                case 9:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }
    }
}