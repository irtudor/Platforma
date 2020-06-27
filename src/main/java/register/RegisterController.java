package register;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class RegisterController {
    @FXML
    private ChoiceBox rolereg;
    @FXML
    private TextField userreg;
    @FXML
    private TextField mailreg;
    @FXML
    private TextField cardreg;
    @FXML
    private PasswordField passreg;
    @FXML
    private Button confirmreg;

    public void initialize(){
        rolereg.getItems().setAll("Manager","User");
    }

}
