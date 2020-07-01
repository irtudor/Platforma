package customer;

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
import models.User;
import services.MoviesService;
import services.SeriesService;
import services.UsersService;

import java.io.IOException;
import java.util.List;

public class CustomerController {

    @FXML
    private ChoiceBox moviesList;
    @FXML
    private Text movieDetails;
    @FXML
    private TextField movieRateInput;
    @FXML
    private Button movieRateCommand;
    @FXML
    private Button watchMovieButton;

    @FXML
    private ChoiceBox seriesList;
    @FXML
    private Text seriesDetails;
    @FXML
    private TextField seriesRateInput;
    @FXML
    private Button seriesRateCommand;
    @FXML
    private Button seriesMovieButton;

    @FXML
    private Text log;

    public static User user;
    public static List<Movie> movies;
    public static List<Series> series;

    public void initialize(){
        if (!user.accountActive()){
            log.setText("Your account has expired!");
            moviesList.setDisable(true);
            seriesList.setDisable(true);
            return;
        }

        for (Movie movie : movies){
            moviesList.getItems().add(movie.getTitle());
        }
        moviesList.getSelectionModel().selectFirst();

        for (Series singleSeries : series){
            seriesList.getItems().add(singleSeries.getTitle() + " S:" + singleSeries.getSeason() + " E:" + singleSeries.getEpisode());
        }

        moviesList.getSelectionModel().selectFirst();
        seriesList.getSelectionModel().selectFirst();

        movieRateCommand.setDisable(user.getRatedVideos().contains(movies.get(0).getTitle()));
        seriesRateCommand.setDisable(user.getRatedVideos().contains(series.get(0).getTitle()));
    }

    public static void openCustomerPanel() throws IOException {
        Parent customerWindow = FXMLLoader.load(CustomerController.class.getResource("/user.fxml"));
        Scene customerScene = new Scene(customerWindow);
        Stage window = new Stage();
        window.setScene(customerScene);
        window.setTitle("USER");
        window.show();
    }

    public void handleMovieChanged() {
        try {
            for (Movie movie : movies){
                if (moviesList.getValue().toString().equals(movie.getTitle())){
                    movieRateCommand.setDisable(user.getRatedVideos().contains(movie.getTitle()));
                    String rating = "-";
                    if (movie.getNrOfRatings() > 0){
                        rating = movie.getRate() + "";
                    }
                    movieDetails.setText("Year: " + movie.getYear() +
                            "\nDescription: " + movie.getDescription() +
                            "\nReview: " + movie.getReview() +
                            "\nRate: " + rating);
                }
            }
        } catch (Exception e) {
            log.setText(e.getMessage());
        }
    }

    public void handleMovieRateCommand(){
        try {
            int rate = Integer.parseInt(movieRateInput.getText());
            for (Movie movie : movies){
                if (moviesList.getValue().toString().equals(movie.getTitle())){
                    movie.setNrOfRatings(movie.getNrOfRatings()+1);
                    if (movie.getNrOfRatings() == 1){
                        movie.setRate(rate);
                    }
                    else {
                        movie.setRate(movie.getRate() + ((rate - movie.getRate()) /(double) movie.getNrOfRatings()));
                    }
                    movieDetails.setText("Year: " + movie.getYear() +
                            "\nDescription: " + movie.getDescription() +
                            "\nReview: " + movie.getReview() +
                            "\nRate: " + movie.getRate());
                    user.addRatedVideo(movie.getTitle());
                    movieRateCommand.setDisable(user.getRatedVideos().contains(movie.getTitle()));
                    UsersService.persistUsers();
                }
            }
            MoviesService.movies = movies;
            MoviesService.persistMovies();
        } catch (Exception e) {
            log.setText(e.getMessage());
        }
    }

    public void handleWatchMovie(){
        log.setText("Watching movie... :)");
    }

    public void handleSeriesChanged() {
        try {
            for (Series singleSeries : series){
                if (seriesList.getValue().toString().equals(singleSeries.getTitle() + " S:" + singleSeries.getSeason() + " E:" + singleSeries.getEpisode())){
                    seriesRateCommand.setDisable(user.getRatedVideos().contains(singleSeries.getTitle()));
                    String rating = "-";
                    if (singleSeries.getNrOfRatings() > 0){
                        rating = singleSeries.getRate() + "";
                    }
                    seriesDetails.setText("Year: " + singleSeries.getYear() +
                            "\nSeason: " + singleSeries.getSeason() +
                            "\nEpisode: " + singleSeries.getEpisode() +
                            "\nDescription: " + singleSeries.getDescription() +
                            "\nReview: " + singleSeries.getReview() +
                            "\nRate: " + rating);
                }
            }
        } catch (Exception e) {
            log.setText(e.getMessage());
        }
    }

    public void handleSeriesRateCommand(){
        try {
            int rate = Integer.parseInt(seriesRateInput.getText());
            for (Series singleSeries : series){
                if (seriesList.getValue().toString().equals(singleSeries.getTitle() + " S:" + singleSeries.getSeason() + " E:" + singleSeries.getEpisode())){
                    singleSeries.setNrOfRatings(singleSeries.getNrOfRatings()+1);
                    if (singleSeries.getNrOfRatings() == 1){
                        singleSeries.setRate(rate);
                    }
                    else {
                        singleSeries.setRate(singleSeries.getRate() + ((rate - singleSeries.getRate()) /(double) singleSeries.getNrOfRatings()));
                    }
                    seriesDetails.setText("Year: " + singleSeries.getYear() +
                            "\nSeason: " + singleSeries.getSeason() +
                            "\nEpisode: " + singleSeries.getEpisode() +
                            "\nDescription: " + singleSeries.getDescription() +
                            "\nReview: " + singleSeries.getReview() +
                            "\nRate: " + singleSeries.getRate());
                    user.addRatedVideo(singleSeries.getTitle());
                    seriesRateCommand.setDisable(user.getRatedVideos().contains(singleSeries.getTitle()));
                    UsersService.persistUsers();
                }
            }
            SeriesService.seriesList = series;
            SeriesService.persistSeries();
        } catch (Exception e) {
            log.setText(e.getMessage());
        }
    }

    public void handleWatchSeries(){
        log.setText("Watching series... :)");
    }
}
