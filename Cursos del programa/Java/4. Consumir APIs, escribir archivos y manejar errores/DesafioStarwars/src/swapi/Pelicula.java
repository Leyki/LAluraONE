package swapi;

public class Pelicula {
    String title;
    int episodeId;
    String openingCrawl;
    String director;
    String producer;
    String releaseDate;
    String[] characters;
    String[] planets;
    String[] starShips;
    String[] vehicles;
    String[] species;
    String url;

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return """
                %s - director: %s - productor: %s - fecha de lanzamiento: %s' - url: %s
                """.formatted(title, director, producer, releaseDate, url);
    }
}

