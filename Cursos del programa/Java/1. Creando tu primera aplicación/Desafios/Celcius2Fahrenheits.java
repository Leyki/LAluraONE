public class Celcius2Fahrenheits {
    public static void main(String[] args) {
         /*
        Escribe un programa que convierta una temperatura en grados Celsius a Fahrenheit.
        Utiliza variables para representar los valores de las temperaturas e imprime en
        la consola el valor convertido de Celsius a Fahrenheit.
         */
        double celsius = 10;
        double fahrenheit = (celsius * 1.8) + 32;
        System.out.printf("%.2f°c = %.2f°f%n", celsius, fahrenheit);
    }
}
