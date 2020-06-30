package exceptions;

public class MovieAlreadyExistsException extends Exception{
    private String movieTitle;

    public MovieAlreadyExistsException(String movieTitle) {
        super(String.format("A movie with the title %s already exists!", movieTitle));
        this.movieTitle = movieTitle;
    }

    public String getMovieTitle() {
        return movieTitle;
    }
}
