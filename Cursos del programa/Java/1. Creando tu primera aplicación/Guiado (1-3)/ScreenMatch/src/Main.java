import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido/a a Screen Match");
        System.out.println("Pelicula: Matrix");

         int fechaLanzamiento = 1999;
         boolean incluidoEnPlan = true;
         float notaDePelicula = 8.2f;

         float media = ((8.2f + 9.2f + 9.0f) / 3);
         int estrellas = (int) media / 2;
        System.out.println(media);

        String sinopsis = """
        Matrix es una paradoja
        
        La mejor pelicula del fin del milenio.
        Fue lanzada en: %d
        Estrellas: %d""".formatted(fechaLanzamiento, estrellas);

        System.out.println(sinopsis);

    }
}