package Controller;

import Exceptions.SongsExceptions;
import Exceptions.StorifyExceptions;
import Exceptions.UserExceptions;
import Models.*;
import Models.Person.Administrator;
import Models.Person.User;
import Utils.CustomAlert;
import Utils.ModelFactoryController;
import Utils.getStage;
import daoController.PersonaController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import Models.Person.Persona;

import java.io.IOException;


public class LoginController {
    ModelFactoryController modelFactoryController;
    Administrator administrator;
    User user;
    PersonaController personaController = new PersonaController();

    public LoginController(ModelFactoryController modelFactoryController) throws IOException, UserExceptions, SongsExceptions {
        this.modelFactoryController = modelFactoryController;
        modelFactoryController.setStorify(new Storify());
//        modelFactoryController.getStorify().setUsers(Persistence.loadUsers());
//        modelFactoryController.getStorify().setAdministrators(Persistence.loadAdministrator());
//        modelFactoryController.getStorify().setSongs(loadSongs());
//        modelFactoryController.setFavoriteSongs(loadSongsUser());
//        modelFactoryController.getStorify().setArtists(Persistence.loadArtist());
//        if (modelFactoryController.getStorify().getUsers().size() == 0) {
//            initializeUsers();
//        }
//        if (modelFactoryController.getStorify().getAdministrators().size() == 0) {
//            initializeAdministrator();
//        }
    }

//    public void initializeUsers() throws UserExceptions, IOException {
//        this.modelFactoryController.getStorify().getUsers().add(new User("user", "user1", "user1@gmail.com", "src/main/resources/Persistence/SongListUser.txt"));
//        Persistence.saveUser(modelFactoryController.getStorify().getUsers());
//        this.modelFactoryController.setFavoriteSongs(Persistence.loadSongsUser());
//    }
//
//    public void initializeAdministrator() throws UserExceptions, IOException {
//        this.modelFactoryController.getStorify().getAdministrators().add(new Administrator("admin", "$aDmiN"));
//        Persistence.saveAdministrator(modelFactoryController.getStorify().getAdministrators());
//    }

    public void login(String userName, String password) throws StorifyExceptions, IOException {

        Persona user = personaController.verificarLogin(userName, password);

        if (user != null) {

            this.modelFactoryController.getStorify().setUser(true);
            this.modelFactoryController.getStorify().setUser(user);

            navigateToHomeUser();

        }

//        else if (validateAdministrator(userName, password)) {
//            this.modelFactoryController.getStorify().setAministrator(true);
//            this.modelFactoryController.getStorify().setAdministrator(administrator);
//        }

        else {
            preparateAlert();
        }
    }

//    private boolean validateUser(String userName, String password) {
//        for (User user : modelFactoryController.getStorify().getUsers()) {
//            if (user.getUsername().equals(userName) && user.getPassword().equals(password)) {
//                this.user = user;
//                navigateToHomeUser();
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean validateAdministrator(String userName, String password) {
//        for (Administrator administrator : modelFactoryController.getStorify().getAdministrators()) {
//            if (administrator.getUsername().equals(userName) && administrator.getPassword().equals(password)) {
//                this.administrator = administrator;
//                navigateToHomeAdministrator();
//                return true;
//            }
//        }
//        return false;
//    }

    private void navigateToHomeUser() {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("homePage-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1283, 698);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        getStage.stage.setTitle(null);
        getStage.stage.setScene(scene);
        getStage.stage.centerOnScreen();
        getStage.stage.show();
    }

//    private void navigateToHomeAdministrator() {
//        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("addArtist-view.fxml"));
//        Scene scene = null;
//        try {
//            scene = new Scene(fxmlLoader.load(), 1280, 705);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        getStage.stage.setTitle(null);
//        getStage.stage.setScene(scene);
//        getStage.stage.centerOnScreen();
//        getStage.stage.show();
//    }

    public void preparateAlert() {
        CustomAlert.showMessage("¡Notificación!", "Usuario o contraseña incorrectos.",
                "Por favor ingrese un usuario y/o constraseña válido.", Alert.AlertType.WARNING);
    }

}
