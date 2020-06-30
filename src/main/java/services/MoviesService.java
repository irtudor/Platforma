package services;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import customer.CustomerController;
import exceptions.MovieAlreadyExistsException;
import models.Movie;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class MoviesService {
    public static List<Movie> movies;
    private static final Path MOVIES_PATH=FileSystemService.getPathToFile(".config","movies.json");

    public static void loadMoviesFromFile() throws IOException {
        if (!Files.exists(MOVIES_PATH)) {
            FileUtils.copyURLToFile(MoviesService.class.getClassLoader().getResource("movies.json"), MOVIES_PATH.toFile());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        movies = objectMapper.readValue(MOVIES_PATH.toFile(), new TypeReference<List<Movie>>() {
        });
        CustomerController.movies = movies;
    }

    public static void addMovie(String title, String year, String description, String review) throws MovieAlreadyExistsException, IOException {
        checkMovieDoesNotAlreadyExist(title);
        movies.add(new Movie(title, year, description, review));
        persistMovies();
    }

    private static void checkMovieDoesNotAlreadyExist(String title) throws MovieAlreadyExistsException {
        for (Movie movie : movies) {
            if (Objects.equals(title, movie.getTitle()))
                throw new MovieAlreadyExistsException(title);
        }
    }

    private static void persistMovies() throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(MOVIES_PATH.toFile(), movies);
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
