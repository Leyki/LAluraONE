import com.aluracursos.screenmatch.calculos.CalculadoraTiempo;
import com.aluracursos.screenmatch.calculos.Recomendaciones;
import com.aluracursos.screenmatch.modelos.*;

public class Principal {
    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula();
        pelicula1.setNombre("supaidamn 2");
        pelicula1.setDuracion(120);
        pelicula1.setFechaLanzamiento(1990);
        pelicula1.setIncluidoEnPlan(true);

        Pelicula pelicula2 = new Pelicula();
        pelicula2.setNombre("supaidamn 1");
        pelicula2.setDuracion(100);
        pelicula2.setFechaLanzamiento(1988);
        pelicula2.setIncluidoEnPlan(true);

        Serie casaDragon = new Serie();
        casaDragon.setNombre("La casa del dragon");
        casaDragon.setTemporadas(2);
        casaDragon.setEpisodiosTemporada(10);
        casaDragon.setDuracionEpisodio(20);
        casaDragon.setIncluidoEnPlan(true);
        casaDragon.mostrarFichaTecnica();

        System.out.println(pelicula1.getNotasCantidad());
        System.out.println(pelicula1.getNotasTotal());

        pelicula1.mostrarFichaTecnica();

        pelicula1.sumarNota(5);
        pelicula1.sumarNota(1);
        pelicula1.sumarNota(10);

        System.out.println(pelicula1.calcularMedia());


        CalculadoraTiempo calculadora = new CalculadoraTiempo();

        calculadora.incluir(pelicula1);
        calculadora.incluir(casaDragon);
        calculadora.incluir(pelicula2);

        System.out.println("Tiempo necesario para ver tus títulos favoritos estas vacaciones: " + calculadora.getTiempoTotal() + " minutos");

        Recomendaciones recomendaciones = new Recomendaciones();

        recomendaciones.filtrar(pelicula1);

        Episodio episodio1 = new Episodio();

        episodio1.setNombre("primero");
        episodio1.setNumero(1);
        episodio1.setSerie(casaDragon);
        episodio1.setTotalVisualiciones(40);

        recomendaciones.filtrar(episodio1);
    }
}
