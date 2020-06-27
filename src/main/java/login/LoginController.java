package login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField userin;
    @FXML
    private PasswordField passin;
    @FXML
    private ChoiceBox role;
    @FXML
    private Button logginbutton;
    @FXML
    private Button createbutton;


public void initialize(){
    role.getItems().setAll("Manager","User");
}

public void openRegister() throws Exception{
    Parent registerWindow = FXMLLoader.load(getClass().getResource("/register.fxml"));
    Scene registerScene = new Scene(registerWindow);
    Stage window = new Stage();
    window.setScene(registerScene);
    window.setTitle("Register");
    window.show();
}
}