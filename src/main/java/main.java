import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.FileSystemService;
import services.MoviesService;
import services.UsersService;

import java.nio.file.Path;

public class main extends Application {
    private static final Path USERS_PATH = FileSystemService.getPathToFile("config", "users.json");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        UsersService.loadUsersFromFile();
        MoviesService.loadMoviesFromFile();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();

    }
}
