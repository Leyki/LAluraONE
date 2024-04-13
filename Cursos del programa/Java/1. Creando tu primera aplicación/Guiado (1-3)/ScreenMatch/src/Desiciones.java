public class Desiciones {
    public static void main(String[] args) {
        int fechaLanzamiento = 1999;
        boolean incluidoEnPlan = true;
        float notaDePelicula = 8.2f;
        String tipoPlan = "plus";

        if (fechaLanzamiento > 2022) {
            System.out.println("Es una pelicula actual");
        } else {
            System.out.println("Es una pelicula retro");
        }

        if (incluidoEnPlan && tipoPlan.equals("plus")) {
            System.out.println("Disfrute la pelicula!");
        }
        else {
            System.out.println("Pelicula no es parte del plan");
        }
    }
}
