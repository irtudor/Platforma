package register;

import exceptions.UsernameAlreadyExistsException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.UsersService;
import javafx.scene.text.Text;

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
    @FXML
    private Text registerMessage;

    public void initialize(){
        rolereg.getItems().setAll("Manager","User");
    }
    public void handleRegisterAction() {
        try {
            UsersService.addUser(userreg.getText(), passreg.getText(), (String)rolereg.getValue(),mailreg.getText(),cardreg.getText());
            registerMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registerMessage.setText(e.getMessage());
        }
    }
}
