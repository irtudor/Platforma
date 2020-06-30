package exceptions;

public class MovieAlreadyExistsException extends Exception{
    public MovieAlreadyExistsException(String movieTitle) {
        super(String.format("A movie with the title %s already exists!", movieTitle));
    }
}
