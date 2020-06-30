package customer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Movie;
import models.User;

import java.io.IOException;
import java.util.List;

public class CustomerController {

    @FXML
    private ChoiceBox moviesList;
    @FXML
    private ChoiceBox seriesList;
    @FXML
    private Text movieDetails;
    @FXML
    private Text accountExpired;

    public static User user;
    public static List<Movie> movies;

    public void initialize(){
        if (!user.accountActive()){
            accountExpired.setText("Your account has expired!");
            moviesList.setDisable(true);
            seriesList.setDisable(true);
            return;
        }

        for (Movie movie : movies){
            moviesList.getItems().add(movie.getTitle());
        }
        moviesList.getSelectionModel().selectFirst();
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
                    movieDetails.setText("Year: " + movie.getYear() +
                            "\nDescription: " + movie.getDescription() +
                            "\nReview: " + movie.getReview() +
                            "\nRate: " + movie.getRate());
                }
            }

        } catch (Exception e) {

        }
    }
}
