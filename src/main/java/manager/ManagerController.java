package manager;

import exceptions.MovieAlreadyExistsException;
import exceptions.SeriesAlreadyExistsException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Movie;
import models.Series;
import services.MoviesService;
import services.SeriesService;

import java.io.IOException;
import java.util.List;

public class ManagerController {
    @FXML
    private ChoiceBox movies;
    @FXML
    private TextField movieTitle;
    @FXML
    private TextField movieYear;
    @FXML
    private TextField movieDescription;
    @FXML
    private TextField movieReview;
    @FXML
    private Button addMovie;

    @FXML
    private ChoiceBox series;
    @FXML
    private TextField seriesTitle;
    @FXML
    private TextField seriesSeason;
    @FXML
    private TextField seriesEpisode;
    @FXML
    private TextField seriesYear;
    @FXML
    private TextField seriesDescription;
    @FXML
    private TextField seriesReview;
    @FXML
    private Button addSeries;

    @FXML
    private Text actionStatus;

    public void initialize(){
        List<Movie> moviesToLoad = MoviesService.movies;
        for (Movie movieToLoad : moviesToLoad){
            movies.getItems().add(movieToLoad.getTitle());
        }
        movies.getSelectionModel().selectFirst();

        List<Series> seriesToLoad = SeriesService.seriesList;
        for (Series singleSeriesToLoad : seriesToLoad){
            series.getItems().add(singleSeriesToLoad.getTitle() + " S:" + singleSeriesToLoad.getSeason() + " E:" + singleSeriesToLoad.getEpisode());
        }
        series.getSelectionModel().selectFirst();
    }

    public static void openManagerPanel() throws IOException {
        Parent managerWindow = FXMLLoader.load(ManagerController.class.getResource("/manager.fxml"));
        Scene managerScene = new Scene(managerWindow);
        Stage window = new Stage();
        window.setScene(managerScene);
        window.setTitle("MANAGER");
        window.show();
    }

    public void handleAddMovie() {
        try {
            MoviesService.addMovie(movieTitle.getText(), movieYear.getText(), movieDescription.getText(), movieReview.getText());
            movies.getItems().add(movieTitle.getText());
            movies.getSelectionModel().selectFirst();
            actionStatus.setText("Movie added successfully!");
        } catch (MovieAlreadyExistsException | IOException e) {
            actionStatus.setText(e.getMessage());
        }
    }

    public void handleAddSeries() {
        try {
            SeriesService.addSeries(seriesTitle.getText(), seriesSeason.getText(), seriesEpisode.getText(), seriesYear.getText(), seriesDescription.getText(), seriesReview.getText());
            series.getItems().add(seriesTitle.getText() + " S:" + seriesSeason.getText() + " E:" + seriesEpisode.getText());
            series.getSelectionModel().selectFirst();
            actionStatus.setText("Series added successfully!");
        } catch (SeriesAlreadyExistsException | IOException e) {
            actionStatus.setText(e.getMessage());
        }
    }
}