package register;

import exceptions.UsernameAlreadyExistsException;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.UsersService;
import javafx.scene.text.Text;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RegisterController {
    @FXML
    private ChoiceBox rolereg;
    @FXML
    private TextField userreg;
    @FXML
    private TextField mailreg;
    @FXML
    private TextField phonenumberreg;
    @FXML
    private TextField cardreg;
    @FXML
    private TextField cvvreg;
    @FXML
    private Text cardreglabel;
    @FXML
    private Text cvvlabel;
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
            UsersService.addUser(userreg.getText(), passreg.getText(), phonenumberreg.getText(), (String)rolereg.getValue(), mailreg.getText(), cardreg.getText(), cvvreg.getText());
            registerMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registerMessage.setText(e.getMessage());
        }
    }

    public void handleRoleChangedAction() {
        try {
            if (rolereg.getValue().toString().equals("User")){
                cardreg.setVisible(true);
                cardreglabel.setVisible(true);
                cvvreg.setVisible(true);
                cvvlabel.setVisible(true);
            }
            else {
                cardreg.setVisible(false);
                cardreglabel.setVisible(false);
                cvvreg.setVisible(false);
                cvvlabel.setVisible(false);
            }
        } catch (Exception e) {

        }
    }
}
