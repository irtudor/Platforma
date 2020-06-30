package exceptions;

public class SeriesAlreadyExistsException extends Exception{
    public SeriesAlreadyExistsException(String seriesTitle, String season, String episode) {
        super(String.format("A series with the title %s, season %s and episode %s exists!", seriesTitle, season, episode));
    }
}
