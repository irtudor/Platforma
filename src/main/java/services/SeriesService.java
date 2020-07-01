package services;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import customer.CustomerController;
import exceptions.SeriesAlreadyExistsException;
import models.Series;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class SeriesService {
    public static List<Series> seriesList;
    private static final Path SERIES_PATH=FileSystemService.getPathToFile(".config","series.json");

    public static void loadSeriesFromFile() throws IOException {
        if (!Files.exists(SERIES_PATH)) {
            FileUtils.copyURLToFile(SeriesService.class.getClassLoader().getResource("series.json"), SERIES_PATH.toFile());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        seriesList = objectMapper.readValue(SERIES_PATH.toFile(), new TypeReference<List<Series>>() {
        });
        CustomerController.series = seriesList;
    }

    public static void addSeries(String title, String season, String episode, String year, String description, String review) throws SeriesAlreadyExistsException, IOException {
        checkSeriesDoesNotAlreadyExist(title, season, episode);

        seriesList.add(new Series(title, season, episode, year, description, review));
        persistSeries();
    }

    private static void checkSeriesDoesNotAlreadyExist(String title, String season, String episode) throws SeriesAlreadyExistsException {
        for (Series series : seriesList) {
            if (Objects.equals(title, series.getTitle()) &&
                Objects.equals(season, series.getSeason()) &&
                Objects.equals(episode, series.getEpisode()))
                throw new SeriesAlreadyExistsException(title, season, episode);
        }
    }

    public static void persistSeries() throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(SERIES_PATH.toFile(), seriesList);
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
