package customer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerController {
    public static void openCustomerPanel() throws IOException {
        Parent customerWindow = FXMLLoader.load(CustomerController.class.getResource("/user.fxml"));
        Scene customerScene = new Scene(customerWindow);
        Stage window = new Stage();
        window.setScene(customerScene);
        window.setTitle("USER");
        window.show();
    }
}
