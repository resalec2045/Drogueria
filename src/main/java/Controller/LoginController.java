package Controller;

import Models.*;
import Models.Reportes.InformeCliente;
import Utils.CustomAlert;
import Utils.ModelFactoryController;
import Utils.getStage;
import daoController.ClienteController;
import daoController.PersonaController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import Models.Person.Persona;

import java.io.IOException;
import java.util.List;


public class LoginController {

    ModelFactoryController modelFactoryController;
    PersonaController personaController = new PersonaController();
    ClienteController clienteController = new ClienteController();

    public LoginController(ModelFactoryController modelFactoryController) throws IOException {
        this.modelFactoryController = modelFactoryController;
        modelFactoryController.setStorify(new Storify());

    }

    public void login(String userName, String password) {

        Persona user = personaController.verificarLogin(userName, password);

        if (user != null) {

            this.modelFactoryController.getStorify().setUser(true);
            this.modelFactoryController.getStorify().setUser(user);

            navigateToHomeUser();

        }

        else {
            preparateAlert();
        }
    }

    private void navigateToHomeUser() {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("homePage-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 950, 698);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        getStage.stage.setTitle(null);
        getStage.stage.setScene(scene);
        getStage.stage.centerOnScreen();
        getStage.stage.show();
    }

    public void preparateAlert() {
        CustomAlert.showMessage("¡Notificación!", "Usuario o contraseña incorrectos.",
                "Por favor ingrese un usuario y/o constraseña válido.", Alert.AlertType.WARNING);
    }

}
