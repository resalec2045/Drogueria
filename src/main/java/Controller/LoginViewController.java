package Controller;
import Utils.ModelFactoryController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginViewController {
    ModelFactoryController modelFactoryController;
    LoginController loginViewController;

    @FXML
    private TextField fieldUserName;

    @FXML
    private TextField fieldPassword;

    @FXML
    void initialize() throws IOException {
        modelFactoryController = ModelFactoryController.getInstance();
        loginViewController = new LoginController(modelFactoryController);
    }
    @FXML
    protected void login() throws IOException {
        loginViewController.login(fieldUserName.getText(), fieldPassword.getText());
    }
}
