import java.util.Scanner;
import librerias.Utils;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateApi.requestCurrencyData();

        var myExchangeRate = new ExchangeRateApi();

        ExchangeRateApi.showSupportedCurrencies();
        System.out.println("Uso: 'cantidad' 'moneda' a 'moneda' (Ejem. 50 ars a usd)");
        while (true) {
            String[] inputs = scanner.nextLine().split(" ");
//            System.out.println(Arrays.toString(inputs));

            boolean success = false;
            if (!Utils.isNumeric(inputs[0], '.')) {
                System.out.println("La cantidad dada no es un número."); continue;
            }

            if (inputs.length == 1) {
                if (myExchangeRate.lastExchangeRate1 != null)
                    success = myExchangeRate.requestExchange(Double.parseDouble(inputs[0]), "", "");
                else
                    System.out.println("Se ha dado una cantidad pero no hay niguna 'moneda a moneda' guardada.");
            }
            else if (inputs.length < 4) {
                System.out.println("No se ha sado suficientes argumentos."); continue;
            }
            else
                success = myExchangeRate.requestExchange(Double.parseDouble(inputs[0]), inputs[1], inputs[3]);

            if (!success) {
                System.out.println("Error de api, tipo de moneda o la cantidad inputada es demasiada.");
            }
        }
    }
}